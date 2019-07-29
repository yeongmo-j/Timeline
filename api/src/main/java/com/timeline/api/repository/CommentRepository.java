package com.timeline.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.timeline.api.entity.CommentEntity;

public interface CommentRepository extends CrudRepository<CommentEntity, Long>{

	@Query(value="SELECT * FROM COMMENT WHERE articleID = ?1 ORDER BY id", nativeQuery=true)
	List<CommentEntity> findByArticleID(long articleID);
	
	void deleteByArticleID(long articleID);
	
	void deleteById(long id);
}
