package com.timeline.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.timeline.api.entity.FriendRelationshipEntity;
import com.timeline.api.repository.FriendRelationshipRepository;

@Service
public class FriendRelationshipServiceImpl implements FriendRelationshipService{
	
	@Autowired
	FriendRelationshipRepository friendRelationshipRepository;

	@Override
	public void insert(FriendRelationshipEntity friendRelationshipEntity) {
		//아이디를 서로 바꿔서 엔티티를 하나 만들어준다
		FriendRelationshipEntity clone = new FriendRelationshipEntity();
		clone.setUserID1(friendRelationshipEntity.getUserID2());
		clone.setUserID2(friendRelationshipEntity.getUserID1());
		
		//두개의 엔티티를 각각 DB에 저장
		friendRelationshipRepository.save(friendRelationshipEntity);
		friendRelationshipRepository.save(clone);
	}

	@Override
	public void delete(FriendRelationshipEntity friendRelationshipEntity) {
		//각각 두번을 삭제
		friendRelationshipRepository.deleteByUserID1AndUserID2(friendRelationshipEntity.getUserID1(), friendRelationshipEntity.getUserID2());
		friendRelationshipRepository.deleteByUserID1AndUserID2(friendRelationshipEntity.getUserID2(), friendRelationshipEntity.getUserID1());
	}
}
