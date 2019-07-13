package com.timeline.api.repository;

import org.springframework.data.repository.CrudRepository;

import com.timeline.api.entity.LikedEntity;

public interface LikedRepository extends CrudRepository<LikedEntity, Integer>{
	
	boolean existsByArticleIDAndUserID(int articleID, int userID);
		
	void deleteByArticleIDAndUserID(int articleID, int userID);
	
	void deleteByArticleID(int articleID);

}
