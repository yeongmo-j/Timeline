package com.timeline.api.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.timeline.api.entity.CommentEntity;
import com.timeline.api.entity.UserEntity;
import com.timeline.api.forresponse.CommentResponse;
import com.timeline.api.graphEntity.CommentedEdgeProps;
import com.timeline.api.graphEntity.DeleteAllEdgesEntity;
import com.timeline.api.graphEntity.GetEdgeEntity;
import com.timeline.api.graphEntity.GetEdgeStep;
import com.timeline.api.graphEntity.HttpFactory;
import com.timeline.api.graphEntity.InsertEdgeEntity;
import com.timeline.api.graphEntity.RequestEdgeEntity;
import com.timeline.api.repository.UserRepository;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    HttpFactory factory;
		
	@Autowired
	UserRepository userRepository;
	
	/*
	 * 필요한 정보들 : 
	 * 댓글id, 소식id, 유저id, 유저이름, 유저프로필사진, 댓글 본문, 작성 시간
	 * 이 정보들을 각각 수집해서 조합해준다
	 */
	private CommentResponse formattingComment(CommentEntity comment) {
		UserEntity user = userRepository.findById(comment.getUserID());
		CommentResponse responseElement = new CommentResponse()
				.setArticleID(comment.getArticleID())
				.setUserID(user.getId())
				.setUsername(user.getUsername())
				.setProfile(user.getProfile())
				.setContent(comment.getContent())
				.setCreatedtime(comment.getCreatedtime());
		return responseElement;
	}

	
	@Override
	public CommentResponse insertComment(CommentEntity commentEntity) {
		//코멘트 저장 
		commentEntity.setCreatedtime(factory.getTimeStamp());
		
		CommentedEdgeProps props = new CommentedEdgeProps();
		props.setContent(commentEntity.getContent());
		
		InsertEdgeEntity insertEdgeEntity = new InsertEdgeEntity();
		insertEdgeEntity.setTimestamp(commentEntity.getCreatedtime());
		insertEdgeEntity.setLabel(factory.getCommentedLabel());
		insertEdgeEntity.setFrom(commentEntity.getUserID());
		insertEdgeEntity.setTo(commentEntity.getArticleID());
		insertEdgeEntity.setProps(props);
		
		List<RequestEdgeEntity> edgeList = new LinkedList<>();
		edgeList.add(insertEdgeEntity);
		
		factory.getRestTemplate().postForObject(factory.getInsertEdgeUrl(), edgeList, List.class);
		
		//방금 작성한 코멘트
		CommentResponse comment = formattingComment(commentEntity);
		
		return comment;
	}

	@Override
	public CommentResponse[] getCommentList(long articleID) {
		
		GetEdgeEntity getEdgeEntity = new GetEdgeEntity();
		getEdgeEntity.setSrcVerticesServiceName(factory.getServiceName());
		getEdgeEntity.setSrcVerticesColumnName(factory.getArticleIDColumn());
		getEdgeEntity.setSrcVerticesID(articleID);
		GetEdgeStep commentStep = new GetEdgeStep();
		commentStep.setDirection("in");
		commentStep.setLabel(factory.getCommentedLabel());
		commentStep.setOffset(0);
		commentStep.setLimit(100);
		getEdgeEntity.setNextStep(commentStep);
		
		Map<String, Object>response = factory.getRestTemplate().postForObject(factory.getGetEdgesUrl(), getEdgeEntity, Map.class);
		List<Map<String, Object>> results = (List<Map<String, Object>>) response.get("results");
		System.out.println(results.toString());
		int size = results.size();
		CommentResponse[] formmedCommentList = new CommentResponse[size];

		Map<String, Object> comment;
		CommentEntity commentEntity = new CommentEntity();
		for (int i=0; i<size ; i++) {
			comment = results.get(i);
			commentEntity.setArticleID(factory.convertToLong(comment.get("from")));
			commentEntity.setUserID(factory.convertToLong(comment.get("to")));
			commentEntity.setCreatedtime(factory.convertToLong(comment.get("timestamp")));
			commentEntity.setContent((String)((Map<String,Object>)comment.get("props")).get("content"));
			
			formmedCommentList[i] = this.formattingComment(commentEntity);
		}
		return formmedCommentList;
	}

	@Override
	public void deleteAllComments(long articleID) {
		
		DeleteAllEdgesEntity deleteAllEdgesEntity = new DeleteAllEdgesEntity();
		deleteAllEdgesEntity.getIds().add(articleID);
		deleteAllEdgesEntity.setLabel(factory.getCommentedLabel());
		deleteAllEdgesEntity.setDirection("in");
		
		List<RequestEdgeEntity> edgeList = new LinkedList<>();
		edgeList.add(deleteAllEdgesEntity);
		
		factory.getRestTemplate().postForObject(factory.getDeleteAllEdgeUrl(), edgeList, List.class);
		
	}

	@Override
	public void deleteComment(long commentID) {
		//여기 구현 못함
	}

	
}
