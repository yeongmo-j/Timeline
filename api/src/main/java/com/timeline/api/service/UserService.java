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
	
	/*
	 * 이메일주소로 비밀번호 질문 찾기
	 * 해당하는 이메일의 회원이 존재하면, 질문만이 담겨있는 entity 반환, 없으면 null 리
	 */
	UserEntity getPasswordQuestion(UserEntity userEntity);
	
	/*
	 * 비밀번호 찾기 질문에 해당하는 정답이 일치하는지를 확인
	 * 올바르면 true 뭔가 문제가 있으면 false
	 */
	boolean checkAnswer(UserEntity userEntity);
	
	/*
	 * 비밀번호 새로운 비밀번호로 리셋
	 * 무슨 문제가 있으면 null, 제대로 변경되었음면 entity 반환
	 */
	UserEntity resetPassword(UserEntity userEntity);
	
	/*
	 * 프로필 사진 변경
	 * id로 db에 저장된 회원을 찾은 뒤에, 프로필을 변경 해 준다.
	 */
	UserEntity changeProfile(UserEntity userEntity);
}
