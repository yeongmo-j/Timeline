package com.timeline.api.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.timeline.api.entity.LikedEntity;

public interface LikedRepository extends CrudRepository<LikedEntity, Integer>{
	
	@Query(value = "SELECT * FROM LIKED WHERE articleID = ?1 AND userID = ?2", nativeQuery=true)
	LikedEntity findIfExist(int articleID, int userID);
	
	/*
	@Query(value = "DELETE FROM LIKED WHERE articleID = ?1 AND userID = ?2", nativeQuery=true)
	void deleteLike(int articleID, int userID);
	*/
	
	void deleteByArticleIDAndUserID(int articleID, int userID);

}
