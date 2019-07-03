package com.timeline.api.service;

import com.timeline.api.entity.UserEntity;

public interface UserService {
	
	boolean registUser(UserEntity userEntity);
	
	boolean login(UserEntity userEntity);

}
