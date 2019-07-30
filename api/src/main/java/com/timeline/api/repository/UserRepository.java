package com.timeline.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.timeline.api.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long>{

	boolean existsByEmail(String email);
	 		
	UserEntity findByEmail(String email);
	
	UserEntity findById(long id);
	
	@Query(value="SELECT * FROM USER WHERE username like %?1%", nativeQuery=true)
	List<UserEntity> findByUserName(String userName);

}
