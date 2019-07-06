package com.timeline.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.timeline.api.entity.UserEntity;
import com.timeline.api.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService, UserDetailsService{
	
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
	
	//UserDetailService 인터페이스 구현
	@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//UserDetails = 대부분의 웹사이트에서 사용하는 계정관련 property들을 추상화한 인터페이스 이걸로 변환시켜 줘야 함

		UserEntity userEntity = userRepository.findByUsername(username);
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		
		return new User(userEntity.getUsername(), userEntity.getPassword(), authorities);
		/*
		UserDetails userDetails = new UserDetails() {
			
			@Override
			public boolean isEnabled() {
				// TODO Auto-generated method stub
				return true;
			}
			
			@Override
			public boolean isCredentialsNonExpired() {
				// TODO Auto-generated method stub
				return true;
			}
			
			@Override
			public boolean isAccountNonLocked() {
				return true;
			}
			
			@Override
			public boolean isAccountNonExpired() {
				// DB안에 이 username이 유일해야 함! 이거 다시 신경써주기
				return true;
			}
			
			@Override
			public String getUsername() {
				return userEntity.getUsername();
			}
			
			@Override
			public String getPassword() {
				return userEntity.getPassword();
			}
			
			@Override
			public Collection<? extends GrantedAuthority> getAuthorities() {
				// TODO 이부분 테이블로 관리되도록 바꿔줄 것
				List<GrantedAuthority> authorities = new ArrayList<>();
				authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
				return authorities;
			}
			
		};*/
	}

}
