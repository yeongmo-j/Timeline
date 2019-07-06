package com.timeline.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.timeline.api.entity.UserEntity;
import com.timeline.api.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
		
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
	public boolean login(UserEntity userEntity) {
		//로그인 성공이면 true를 반환
		String encodedPassword = userRepository.getPassword(userEntity.getUsername());
		if (passwordEncoder.matches(userEntity.getPassword(), encodedPassword))
			return true;
		return false;
	}

}
