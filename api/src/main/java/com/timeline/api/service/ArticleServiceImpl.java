package com.timeline.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.timeline.api.entity.ArticleEntity;
import com.timeline.api.entity.UserEntity;
import com.timeline.api.forresponse.ArticleResponse;
import com.timeline.api.repository.ArticleRepository;
import com.timeline.api.repository.CommentRepository;
import com.timeline.api.repository.LikedRepository;
import com.timeline.api.repository.UserRepository;

@Service
public class ArticleServiceImpl implements ArticleService {
	
	@Autowired
	ArticleRepository articleRepository;
	
	@Autowired
	LikedRepository likedRepository;
	
	@Autowired
	CommentRepository commentRepository;
	
	@Autowired 
	UserRepository userRepository;
	
	/*
	 * 저장된 entity 혹은 불러온 entity를 뷰에서 필요로 하는 데이터들과 함께 조합 해서 
	 * ArticleResponse 인스턴스에 담아서 리턴해준다
	 */
	private ArticleResponse formattingArticle(ArticleEntity article, int userID) {
		//ArticleEntity에는 유저의 id만 존재 할 뿐이지, 유저의 이름, 프로필사진이 정보가 존재하지 않는다.
		//따라서 글을 작성한유저의 정보를 받아온다
		UserEntity user = userRepository.findById(article.getUserID());
		
		//이 글을 불러오기를 요청한 유저가 좋아요를 눌렀으면, liked를 true로 주고, 좋아요를 안눌렀으면 false로 둔다.
		String liked = "true";
		
		if (!likedRepository.existsByArticleIDAndUserID(article.getId(), userID))
			liked = "false";
		
		//뷰에서 필요로 하는 정보들로 조합 해서 리턴 해준다. 
		ArticleResponse responseElement = new ArticleResponse()
				.setArticleID(article.getId())
				.setUserID(article.getUserID())
				.setUsername(user.getUsername()) 
				.setProfile(user.getProfile()) 
				.setContent(article.getContent())
				.setPhoto((article.getPhoto()==null || article.getPhoto().equals("")) ? null : article.getPhoto()) //사진이 없을 경우 처리
				.setLike(article.getLikeCount())
				.setLiked(liked)
				.setCreatedtime(article.getCreatedtime());
		return responseElement;
	}
	
	@Override
	public ArticleResponse insert(ArticleEntity articleEntity) {
		
		//들어온 소식을 저장 해준 후, 저장 된 entity를 받아온다(자동으로 생성된 ID 포함)
		ArticleEntity savedEntity = articleRepository.save(articleEntity);
		
		//뷰에서 필요로 하는 정보들로 조합 해준다.
		ArticleResponse responseElement = formattingArticle(savedEntity, savedEntity.getUserID());

		return responseElement;
	}
	
	@Override
	public ArticleResponse[] getTimeline(int userID) {
		List<ArticleEntity> friendsArticlesList = articleRepository.getTimeline(userID);
		int length = friendsArticlesList.size();
		ArticleResponse[] formmedArticleList = new ArticleResponse[length];
		for (int i=0 ; i<length ; i++) {
			ArticleEntity article = friendsArticlesList.get(i);
			formmedArticleList[i] = formattingArticle(article, userID);
		}
		return formmedArticleList;
	}

	@Override
	public void updateArticle(ArticleEntity articleEntity) {
		articleRepository.save(articleEntity);
	}

	
	@Override
	//@Transactional
	public void deleteArticle(int articleID) {
		//삭제의 과정은 1.소식 삭제 -> 2.해당 좋아요 전체 삭제 -> 3.해당 소식의 모든 댓글 삭제 로 이루어진다. 
		articleRepository.deleteById(articleID);
		likedRepository.deleteByArticleID(articleID);
		commentRepository.deleteByArticleID(articleID);
	}

	@Override
	public ArticleResponse[] getHomeList(int userID) {
		List<ArticleEntity> homeArticleList = articleRepository.getHome(userID);
		int length = homeArticleList.size();
		ArticleResponse[] formmedArticleList = new ArticleResponse[length];
		for (int i=0; i<length ; i++) {
			ArticleEntity article = homeArticleList.get(i);
			formmedArticleList[i] = formattingArticle(article, userID);
		}
		return formmedArticleList;
	}
	
	
}
