package com.timeline.api.service;

import com.timeline.api.entity.UserEntity;

public interface UserService {
	
	UserEntity registUser(UserEntity userEntity);

	UserEntity login(UserEntity userEntity) throws Exception;
	
	UserEntity findById(int id);

}
