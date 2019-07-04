package com.timeline.api.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.timeline.api.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Integer>{
	//회원가입 시에 동일한 이름이 존재하는지 확인
	boolean existsByUsername(String username);
	 
	//로그인 시에 회원이름, 비밀번호 확인
	@Query("SELECT user FROM UserEntity user WHERE user.username = ?1 AND user.password = ?2")
	UserEntity existsByUser(String username, String password);

}
