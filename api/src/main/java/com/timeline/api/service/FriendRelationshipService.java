package com.timeline.api.service;

import com.timeline.api.entity.FriendRelationshipEntity;

public interface FriendRelationshipService {

	FriendRelationshipEntity insert(FriendRelationshipEntity friendRelationshipEntity);
	
	void delete(FriendRelationshipEntity friendRelationshipEntity);
}
