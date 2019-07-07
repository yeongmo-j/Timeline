package com.timeline.api.service;

import com.timeline.api.entity.UserEntity;

public interface JwtService {
	
	String makeJwt(UserEntity userEntity) throws Exception;
	
	boolean checkJwt(String jwt) throws Exception;

}
