package com.timeline.api.repository;

import org.springframework.data.repository.CrudRepository;

import com.timeline.api.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long>{

	boolean existsByEmail(String email);
	 		
	UserEntity findByEmail(String email);
	
	UserEntity findById(long id);

}
