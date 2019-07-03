package com.timeline.api.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.timeline.api.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Integer>{
	boolean existsByUsername(String username);
	
	@Query("SELECT user FROM UserEntity user WHERE user.username = ?1 AND user.password = ?2")
	UserEntity existsByUser(String username, String password);

}
