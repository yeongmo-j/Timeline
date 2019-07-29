package com.timeline.api.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.timeline.api.entity.FriendRelationshipEntity;
import com.timeline.api.graphEntity.DeleteEdgeEntity;
import com.timeline.api.graphEntity.HttpFactory;
import com.timeline.api.graphEntity.InsertEdgeEntity;
import com.timeline.api.graphEntity.RequestEdgeEntity;

@Service
public class FriendRelationshipServiceImpl implements FriendRelationshipService{
	
    @Autowired
    HttpFactory factory;

	@Override
	public void insert(FriendRelationshipEntity friendRelationshipEntity) {
		InsertEdgeEntity insertEdgeEntity = new InsertEdgeEntity();
		insertEdgeEntity.setTimestamp(factory.getTimeStamp());
		insertEdgeEntity.setLabel(factory.getFiendLabel());
		insertEdgeEntity.setFrom(friendRelationshipEntity.getUserID1());
		insertEdgeEntity.setTo(friendRelationshipEntity.getUserID2());
		
		List<RequestEdgeEntity> edgeList = new LinkedList<>();
		edgeList.add(insertEdgeEntity);
		
		factory.getRestTemplate().postForObject(factory.getInsertEdgeUrl(), edgeList, List.class);
	}

	@Override
	public void delete(FriendRelationshipEntity friendRelationshipEntity) {
		DeleteEdgeEntity deleteEdgeEntity = new DeleteEdgeEntity();
		deleteEdgeEntity.setTimestamp(factory.getTimeStamp());
		deleteEdgeEntity.setLabel(factory.getFiendLabel());
		deleteEdgeEntity.setFrom(friendRelationshipEntity.getUserID1());
		deleteEdgeEntity.setTo(friendRelationshipEntity.getUserID2());
		
		List<RequestEdgeEntity> edgeList = new LinkedList<>();
		edgeList.add(deleteEdgeEntity);
		
		factory.getRestTemplate().postForObject(factory.getDeleteEdgeUrl(), edgeList, List.class);
	}
}
