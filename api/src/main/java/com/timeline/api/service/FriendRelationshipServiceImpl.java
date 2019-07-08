package com.timeline.api.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.timeline.api.entity.FriendRelationshipEntity;
import com.timeline.api.repository.FriendRelationshipRepository;

public class FriendRelationshipServiceImpl implements FriendRelationshipService{
	
	@Autowired
	FriendRelationshipRepository friendRelationshipRepository;

	@Override
	public FriendRelationshipEntity insert(FriendRelationshipEntity friendRelationshipEntity) {
		FriendRelationshipEntity clone = new FriendRelationshipEntity();
		clone.setUserID1(friendRelationshipEntity.getUserID2());
		clone.setUserID2(friendRelationshipEntity.getUserID1());
		
		FriendRelationshipEntity result = friendRelationshipRepository.save(friendRelationshipEntity);
		friendRelationshipRepository.save(clone);
		
		return result;
	}

	@Override
	public void delete(FriendRelationshipEntity friendRelationshipEntity) {
		friendRelationshipRepository.delete(friendRelationshipEntity);
	}

}
