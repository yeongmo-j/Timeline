package com.timeline.api.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.timeline.api.entity.UserEntity;
import com.timeline.api.response.Response;
import com.timeline.api.service.UserService;

@CrossOrigin(origins = "*")
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@RequestBody UserEntity userEntity, HttpSession session) {
		//로그인 
		Response response = new Response();
		boolean result = userService.login(userEntity); // 로그인 성공하면 true 실패하면 false
		if (result) {
			//로그인 성공
			response.setCode("200");
			response.setResult("positive");
			//일단 완성된 로그인 환경 전에 임시 방편으로 세션에 사용자 이름만 저장 해 둔다
			session.setAttribute("user", userEntity.getUsername());
		} else {
			//로그인 실패
			response.setCode("401");
			response.setResult("negative");
		}
		return new Gson().toJson(response);
	}
	
	@RequestMapping(value="/regist", method=RequestMethod.POST)
	public String regist(@RequestBody UserEntity userEntity) {
		//회원가입
		Response response = new Response();
		boolean result = userService.registUser(userEntity); //회원가입 성공하면 true 실패하면 false
		if (result) {
			//회원가입 성공
			response.setCode("200");
			response.setResult("positive");
		} else {
			//회원가입 실패
			response.setCode("400");
			response.setResult("negative");
		}
		return new Gson().toJson(response);
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public void logout(HttpSession session) {
		//로그아웃
		session.invalidate();
	}
}
