package com.timeline.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.timeline.api.entity.FriendRelationshipEntity;
import com.timeline.api.entity.UserEntity;
import com.timeline.api.repository.FriendRelationshipRepository;
import com.timeline.api.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	FriendRelationshipRepository friendRelationshipRepository;
	
	@Override
	public UserEntity registUser(UserEntity userEntity) {		
		boolean available = userRepository.existsByEmail(userEntity.getEmail()); //이메일이 존재하면 true가 리턴됨
		if (available) {
			//이미 존재하는 이름이므로 실패
			return null;
		}
		userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword())); //패스워드 암호화
		userEntity.setAnswer(passwordEncoder.encode(userEntity.getAnswer())); //비밀번호 초기화 질문 암호화
		UserEntity savedUser = userRepository.save(userEntity); //저장완료
		
		//자기자신을 친구에 넣어놓음
		FriendRelationshipEntity friendRelationshipEntity = new FriendRelationshipEntity();
		friendRelationshipEntity.setUserID1(savedUser.getId());
		friendRelationshipEntity.setUserID2(savedUser.getId());
		friendRelationshipRepository.save(friendRelationshipEntity);
		
		//저장된 Entity 리턴
		return savedUser;
	}
	
	@Override
	public UserEntity login(UserEntity userEntity){
		boolean available = userRepository.existsByEmail(userEntity.getEmail()); //이메일 있는지 확인
		if (!available) return null ; //없으면 null 리턴
		
		UserEntity findedUser = userRepository.findByEmail(userEntity.getEmail()); //암호화된 비밀번호 받아와
		if (passwordEncoder.matches(userEntity.getPassword(), findedUser.getPassword())) //비밀번호 체크 시 맞으면 
			return findedUser; //해당 엔티티 리턴 
		else
			return null; //비밀번호가 다르면 null 리
	}
	
	@Override
	public UserEntity findById(int id) {
		return userRepository.findById(id);
	}
}
