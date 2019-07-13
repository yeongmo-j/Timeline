package com.timeline.api.service;

import com.timeline.api.entity.UserEntity;

public interface UserService {
	
	/*
	 * 회원가입 시에, 이미 존재하는 이메일로 회원가입 요청 시 null을 반환,
	 * 성공적으로 회원가입이 성공하면 해당 entity 인스턴스를 반환
	 */
	UserEntity registUser(UserEntity userEntity);

	/*
	 * 로그인 시에, 제출된 비밀번홍와 암호화된 비밀번호가 일치하는지 확인
	 * 일치하면 해당 userEntity 반환, 실패하면 null 반환
	 */
	UserEntity login(UserEntity userEntity);
	
	
	UserEntity findById(int id);

}
