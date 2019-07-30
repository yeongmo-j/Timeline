package com.timeline.api.service;

import com.timeline.api.entity.FriendRelationshipEntity;
import com.timeline.api.forresponse.UserResponse;

public interface FriendRelationshipService {

	/*
	 * 해당 유저 2명을 친구로 등록하게 되는데,
	 */
	void insert(FriendRelationshipEntity friendRelationshipEntity);
	
	/*
	 * 해당 유저 2명의 친구관계를 끊어준다
	 */
	void delete(FriendRelationshipEntity friendRelationshipEntity);
	
	/*
	 * 친구 요청 리스트업
	 */
	UserResponse[] getFriendRequest(long userID);
	
	/*
	 * 친구 요청 수락 혹은 거부 
	 */
	void responseToRequest(int type, long from, long to);
	
	/*
	 * 친구 추천 리스트업 
	 */
	UserResponse[] getFriendSuggest(long userID);
	
	/*
	 * 친구 요청 보내주기
	 */
	void sendFriendRequest(long from, long to);
	
	/*
	 * 친구 검색
	 */
	UserResponse[] searchFriend(String userName);
	
	/*
	 * 친구면 1, 친구요청 이미 보낸상태면 2, 친구요청 받은 상태면 3, 아무것도 아니면 4 리턴
	 */
	int getRelationship(long me, long you);
}
