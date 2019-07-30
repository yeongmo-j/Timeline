package com.timeline.api.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.timeline.api.graphEntity.CheckEdgeEntity;
import com.timeline.api.graphEntity.DeleteEdgeEntity;
import com.timeline.api.graphEntity.GetEdgeEntity;
import com.timeline.api.graphEntity.GetEdgeStep;
import com.timeline.api.graphEntity.HttpFactory;
import com.timeline.api.graphEntity.InsertEdgeEntity;
import com.timeline.api.graphEntity.RequestEdgeEntity;

@Service
public class LikedServiceImpl implements LikedService{

    @Autowired
    HttpFactory factory;
	
	@Override
	public void likeOrUnlike(long articleID, long userID) {
		boolean liked = this.heOrSheLikesIt(articleID, userID);
		if (liked) {
			//좋아요가 존재한다는 의미이므로 취소 : 삭제
			DeleteEdgeEntity deleteEdgeEntity = new DeleteEdgeEntity();
			deleteEdgeEntity.setTimestamp(factory.getTimeStamp());
			deleteEdgeEntity.setLabel(factory.getLikedLabel());
			deleteEdgeEntity.setFrom(userID);
			deleteEdgeEntity.setTo(articleID);
			
			List<RequestEdgeEntity> edgeList = new LinkedList<>();
			edgeList.add(deleteEdgeEntity);
			System.out.println("delete Like : " +deleteEdgeEntity.toString());
			factory.getRestTemplate().postForObject(factory.getDeleteEdgeUrl(), edgeList, List.class);
			
		} else {
			//좋아요가 존재하지 않는다는 의미이므로 : 새로 좋아요 만들어줌
			InsertEdgeEntity insertEdgeEntity = new InsertEdgeEntity();
			insertEdgeEntity.setTimestamp(factory.getTimeStamp());
			insertEdgeEntity.setLabel(factory.getLikedLabel());
			insertEdgeEntity.setFrom(userID);
			insertEdgeEntity.setTo(articleID);
			
			List<RequestEdgeEntity> edgeList = new LinkedList<>();
			edgeList.add(insertEdgeEntity);
			
			factory.getRestTemplate().postForObject(factory.getInsertEdgeUrl(), edgeList, List.class);
		}
	}

	@Override
	public int howManyLikes(long articleID) {
		GetEdgeEntity likedRequest = new GetEdgeEntity();
		likedRequest.setSrcVerticesServiceName(factory.getServiceName());
		likedRequest.setSrcVerticesColumnName(factory.getArticleIDColumn());
		likedRequest.setSrcVerticesID(articleID);
		GetEdgeStep step = new GetEdgeStep();
		step.setDirection("in");
		step.setLabel(factory.getLikedLabel());
		step.setLimit(10000);
		step.setOffset(0);
		likedRequest.setNextStep(step);
		Map<String, Object> likedResponse = factory.getRestTemplate().postForObject(factory.getGetEdgesUrl(), likedRequest, Map.class);
		return (int)likedResponse.get("size");
	}

	@Override
	public boolean heOrSheLikesIt(long articleID, long userID) {
		//좋아요 눌렀으면 true 아니면 false를 리턴
		CheckEdgeEntity edge = new CheckEdgeEntity();
		edge.setDirection("out");
		edge.setLabel(factory.getLikedLabel());
		edge.setFrom(userID);
		edge.setTo(articleID);
		List<CheckEdgeEntity> edgeList = new LinkedList<>();
		edgeList.add(edge);
		List response = factory.getRestTemplate().postForObject(factory.getCheckEdgeUrl(), edgeList, List.class);
		if (response.isEmpty())
			return false;
		long timestamp = factory.convertToLong(((Map<String, Object>)((Map<String, Object>)response.get(0)).get("props")).get("_timestamp"));
		long lastDeleteDate = factory.convertToLong(((Map<String, Object>)((Map<String, Object>)response.get(0)).get("props")).get("_lastDeletedAt"));
		if( lastDeleteDate == -1 || timestamp > lastDeleteDate)
			return true;
		return false;
	}
	
}
