package com.timeline.api.service;

import com.timeline.api.entity.FriendRelationshipEntity;

public interface FriendRelationshipService {

	/*
	 * 해당 유저 2명을 친구로 등록하게 되는데,
	 * 첫번째 유저에게 두번째 유저를 친구로 등록해주고
	 * 두번째 유저에게 첫번째 유저를 친구로 등록해준다 (각 한번씩 총 2번)
	 */
	void insert(FriendRelationshipEntity friendRelationshipEntity);
	
	/*
	 * 해당 유저 2명의 친구관계를 끊어준다
	 * 첫번째 유저 - 두번째 유저의 관계를 끊어주고
	 * 두번째 유저 - 첫번째 유저의 관계를 끊어준다 (각 한번씩 총 2번)
	 */
	void delete(FriendRelationshipEntity friendRelationshipEntity);
}
