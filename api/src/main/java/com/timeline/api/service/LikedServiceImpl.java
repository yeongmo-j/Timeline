package com.timeline.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.timeline.api.entity.ArticleEntity;
import com.timeline.api.entity.LikedEntity;
import com.timeline.api.repository.ArticleRepository;
import com.timeline.api.repository.LikedRepository;

@Service
public class LikedServiceImpl implements LikedService{

	@Autowired
	LikedRepository likedRepository;
	
	@Autowired
	ArticleRepository articleRepository;
	
	@Override
	@Transactional
	public void likeOrUnlike(int articleID, int userID) {
		//좋아요를 눌렀었는지 안눌렀었는지 먼저 확인해본다. 
		boolean liked = likedRepository.existsByArticleIDAndUserID(articleID, userID);
		//좋아요 count를 수정 해 줘야 하기 때문에 소식을 찾아온다
		ArticleEntity article = articleRepository.findArticle(articleID);
		if (liked) {
			//좋아요가 존재한다는 의미이므로 취소 : 삭제 후 카운트를 하나 줄여준다
			likedRepository.deleteByArticleIDAndUserID(articleID, userID);
			article.setLikeCount(article.getLikeCount()-1);
		} else {
			//좋아요가 존재하지 않는다는 의미이므로 : 새로 좋아요 만들어서 저장 후 카운트를 하나 늘려준다
			LikedEntity newLike = new LikedEntity();
			newLike.setArticleID(articleID);
			newLike.setUserID(userID);
			likedRepository.save(newLike);
			article.setLikeCount(article.getLikeCount()+1);
		}
		//변경된 카운트 수 저장
		articleRepository.save(article);
	}

	@Override
	public boolean existsByArticleIDAndUserID(int articleID, int userID) {
		return likedRepository.existsByArticleIDAndUserID(articleID, userID);
	}
	
	
}
