package com.timeline.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.timeline.api.entity.ArticleEntity;

public interface ArticleRepository extends CrudRepository<ArticleEntity, Integer>{

	
	//@Query("SELECT article FROM ArticleEntity article INNER JOIN FriendRelationshipEntity friends ON article.userID = friends.userID2 WHERE friends.userID1 = ?1 ORDER BY article.id DESC")
	@Query(value = "SELECT * FROM ARTICLE INNER JOIN FRIENDRELATIONSHIP ON ARTICLE.userid = FRIENDRELATIONSHIP.userid2 WHERE FRIENDRELATIONSHIP.userid1 = ?1 ORDER BY ARTICLE.id DESC", nativeQuery=true)
	List<ArticleEntity> getFriendsArticles(int userID);
}
