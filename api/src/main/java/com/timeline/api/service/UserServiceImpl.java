package com.timeline.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.timeline.api.entity.UserEntity;
import com.timeline.api.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public boolean registUser(UserEntity userEntity) {
		//회원가입 성공하면 true
		boolean available = userRepository.existsByUsername(userEntity.getUsername());
		if (available) {
			//이미 존재하는 이름이므로 실패
			return false;
		}
		userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword())); //패스워드 암호화
		userRepository.save(userEntity);
		return true;
	}
	
	@Override
	public UserEntity login(UserEntity userEntity) throws Exception{
		boolean available = userRepository.existsByUsername(userEntity.getUsername()); //이름 있는지 확인
		if (!available) throw new Exception() ; //없으면 예외 발생
		
		UserEntity findedUser = userRepository.findByUsername(userEntity.getUsername()); //비밀번호 받아와
		if (passwordEncoder.matches(userEntity.getPassword(), findedUser.getPassword())) //비밀번호 맞으면 
			return findedUser; //해당 엔티티 리턴 
		else
			return null; //비밀번호가 다름
	}
	
}
