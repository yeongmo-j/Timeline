package com.timeline.api.repository;

import org.springframework.data.repository.CrudRepository;

import com.timeline.api.entity.FriendRelationshipEntity;

public interface FriendRelationshipRepository extends CrudRepository<FriendRelationshipEntity, Integer>{

	FriendRelationshipEntity deleteByUserID1AndUserID2(int userID1, int userID2);
}
