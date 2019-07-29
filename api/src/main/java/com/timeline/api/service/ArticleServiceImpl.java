package com.timeline.api.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.timeline.api.entity.ArticleEntity;
import com.timeline.api.entity.UserEntity;
import com.timeline.api.forresponse.ArticleResponse;
import com.timeline.api.graphEntity.CheckEdgeEntity;
import com.timeline.api.graphEntity.DeleteEdgeEntity;
import com.timeline.api.graphEntity.GetEdgeEntity;
import com.timeline.api.graphEntity.GetEdgeStep;
import com.timeline.api.graphEntity.HttpFactory;
import com.timeline.api.graphEntity.InsertEdgeEntity;
import com.timeline.api.graphEntity.PostedEdgeProps;
import com.timeline.api.graphEntity.RequestEdgeEntity;
import com.timeline.api.repository.CommentRepository;
import com.timeline.api.repository.UserRepository;


@Service
public class ArticleServiceImpl implements ArticleService {
	    
    @Autowired
    HttpFactory factory;
		
	@Autowired
	LikedService likedService;
		
	@Autowired 
	UserRepository userRepository;
	
	@Autowired
	CommentRepository commentRepository;
	
	/*
	 * 저장된 entity 혹은 불러온 entity를 뷰에서 필요로 하는 데이터들과 함께 조합 해서 
	 * ArticleResponse 인스턴스에 담아서 리턴해준다
	 */
	private ArticleResponse formattingArticle(long articleID, Map<String, Object> articleProps, int userID) {
		//ArticleEntity에는 유저의 id만 존재 할 뿐이지, 유저의 이름, 프로필사진이 정보가 존재하지 않는다.
		//따라서 글을 작성한유저의 정보를 받아온다
		UserEntity user = userRepository.findById(userID);
		
		//이 글을 불러오기를 요청한 유저가 좋아요를 눌렀으면, liked를 true로 주고, 좋아요를 안눌렀으면 false로 둔다.
		String liked = "true";
		if (!likedService.heOrSheLikesIt(articleID, userID))
			liked = "false";
		
		//해당 글에 들어오는 좋아요가 몇갠지?
		int likedCount = likedService.howManyLikes(articleID);
		
		long time = factory.convertToLong(articleProps.get("_timestamp"));		
		
		//뷰에서 필요로 하는 정보들로 조합 해서 리턴 해준다. 
		ArticleResponse responseElement = new ArticleResponse()
				.setArticleID(articleID)
				.setUserID(userID)
				.setUsername(user.getUsername()) 
				.setProfile(user.getProfile()) 
				.setContent((String)articleProps.get("content"))
				.setPhoto( articleProps.get("photo")==null|| ((String)articleProps.get("photo")).equals("-")  ? null : (String)articleProps.get("photo") )
				.setLike(likedCount) 
				.setLiked(liked)
				.setCreatedtime(time);
		return responseElement;
	}
	
	@Override
	public ArticleResponse insert(ArticleEntity articleEntity) {
		
		//사진 설정
		if (articleEntity.getPhoto() == null)
			articleEntity.setPhoto("-");
		
		//새로운 아이디 생성(이부분 바꿔줄 것)
		long newArticleID = factory.getAutoIncreasedID();
		System.out.println("이번에 글 아이디 : " + newArticleID);
		
		//props 만들어주기 
		PostedEdgeProps props = new PostedEdgeProps();
		props.setContent(articleEntity.getContent());
		if (articleEntity.getPhoto() == null)
			props.setPhoto("-");
		else 
			props.setPhoto(articleEntity.getPhoto());
		
		//edge 양식에 맞추기
		InsertEdgeEntity edge = new InsertEdgeEntity();
		edge.setFrom(articleEntity.getUserID());
		edge.setTo(newArticleID);
		edge.setLabel(factory.getPostedLabel());
		edge.setTimestamp(factory.getTimeStamp());
		edge.setProps(props);
		
		//요청 보내기
		Object response = factory.getRestTemplate().postForObject(factory.getInsertEdgeUrl(), edge, String.class);
		
		// 방금 작성한 글 정보 가져오기 
		List<CheckEdgeEntity> edgeList = new LinkedList<>();
		CheckEdgeEntity checkEdge = new CheckEdgeEntity();
		edgeList.add(checkEdge);
		checkEdge.setDirection("out");
		checkEdge.setLabel(factory.getPostedLabel());
		checkEdge.setFrom(articleEntity.getUserID());
		checkEdge.setTo(newArticleID);
		List<Map<String, Object>> response2 = factory.getRestTemplate().postForObject(factory.getCheckEdgeUrl(), edgeList, List.class);
		Map<String, Object> props2 = (Map<String, Object>)response2.get(0).get("props");
		
		//뷰에서 필요로 하는 정보들로 조합 해준다.
		ArticleResponse responseElement = formattingArticle(newArticleID, props2, articleEntity.getUserID());

		return responseElement;
	}
	
	@Override
	public ArticleResponse[] getTimeline(long userID) {
		
		GetEdgeEntity getEdgeEntity = new GetEdgeEntity();
		getEdgeEntity.setSrcVerticesServiceName(factory.getServiceName());
		getEdgeEntity.setSrcVerticesColumnName(factory.getUserIDColumn());
		getEdgeEntity.setSrcVerticesID(userID);
		GetEdgeStep friendStep = new GetEdgeStep();
		friendStep.setDirection("out");
		friendStep.setLabel(factory.getFiendLabel());
		friendStep.setOffset(0);
		friendStep.setLimit(100);
		GetEdgeStep postedStep = new GetEdgeStep();
		postedStep.setDirection("out");
		postedStep.setLabel(factory.getPostedLabel());
		postedStep.setOffset(0);
		postedStep.setLimit(100);
		getEdgeEntity.setNextStep(friendStep);
		getEdgeEntity.setNextStep(postedStep);
		
		Map<String, Object>response = factory.getRestTemplate().postForObject(factory.getGetEdgesUrl(), getEdgeEntity, Map.class);
		List<Map<String, Object>> results = (List<Map<String, Object>>) response.get("results");
		
		int size = results.size();
		ArticleResponse[] formmedArticleList = new ArticleResponse[size];

		Map<String, Object> article;
		int articleUserID;
		long articleID;
		for (int i=0; i<size ; i++) {
			article = results.get(i);
			articleUserID = (int)article.get("from");
			articleID = (long)((int)article.get("to"));
			formmedArticleList[i] = this.formattingArticle(articleID, (Map<String, Object>)article.get("props"), articleUserID);
		}
		return formmedArticleList;
	}

	
	@Override
	@Transactional
	public void deleteArticle(long articleID, long userID) {
		//삭제의 과정은 1.소식 삭제 -> 2.해당 소식의 모든 댓글 삭제 로 이루어진다. 
		//해당 소식 삭제
		DeleteEdgeEntity deleteEdgeEntity = new DeleteEdgeEntity();
		deleteEdgeEntity.setLabel(factory.getPostedLabel());
		deleteEdgeEntity.setTimestamp(factory.getTimeStamp());
		deleteEdgeEntity.setFrom(userID);
		deleteEdgeEntity.setTo(articleID);
		
		System.out.println(deleteEdgeEntity.toString());
		
		List<RequestEdgeEntity> edgeList = new LinkedList<>();
		edgeList.add(deleteEdgeEntity);
		
		factory.getRestTemplate().postForObject(factory.getDeleteEdgeUrl(), edgeList, List.class);

		commentRepository.deleteByArticleID(articleID);

	}

	@Override
	public ArticleResponse[] getHomeList(long userID) {
		
		GetEdgeEntity getEdgeEntity = new GetEdgeEntity();
		getEdgeEntity.setSrcVerticesServiceName(factory.getServiceName());
		getEdgeEntity.setSrcVerticesColumnName(factory.getUserIDColumn());
		getEdgeEntity.setSrcVerticesID(userID);
		GetEdgeStep postedStep = new GetEdgeStep();
		postedStep.setDirection("out");
		postedStep.setLabel(factory.getPostedLabel());
		postedStep.setOffset(0);
		postedStep.setLimit(100);
		getEdgeEntity.setNextStep(postedStep);
		
		Map<String, Object>response = factory.getRestTemplate().postForObject(factory.getGetEdgesUrl(), getEdgeEntity, Map.class);
		List<Map<String, Object>> results = (List<Map<String, Object>>) response.get("results");
		
		int size = results.size();
		ArticleResponse[] formmedArticleList = new ArticleResponse[size];

		Map<String, Object> article;
		int articleUserID;
		long articleID;
		for (int i=0; i<size ; i++) {
			article = results.get(i);
			articleUserID = (int)article.get("from");
			articleID = (long)((int)article.get("to"));
			formmedArticleList[i] = this.formattingArticle(articleID, (Map<String, Object>)article.get("props"), articleUserID);
		}
		return formmedArticleList;
	}
}
