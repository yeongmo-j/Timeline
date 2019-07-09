package com.timeline.api.service;

import com.timeline.api.entity.LikedEntity;

public interface LikedService {

	LikedEntity findIfExist(int articleID, int userID);
	
	void deleteLike(int articleID, int userID);
	
	void insertLike(LikedEntity likedEntity);
}
