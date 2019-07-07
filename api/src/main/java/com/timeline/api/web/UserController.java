package com.timeline.api.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.timeline.api.entity.UserEntity;
import com.timeline.api.service.JwtService;
import com.timeline.api.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private JwtService jwtService;

	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@RequestBody UserEntity userEntity, HttpServletResponse response) {
		//로그인 
		try {
			UserEntity findedUser = userService.login(userEntity); // 로그인 성공하면 true 실패하면 false
			if (findedUser != null) {
				//로그인 성공
				response.setStatus(HttpServletResponse.SC_OK);
				Map<String, Object> user = new HashMap<>();
				user.put("userID", findedUser.getId());
				user.put("username", findedUser.getUsername());
				Map<String, Object> result = new HashMap<>();
				result.put("token", jwtService.makeJwt(findedUser));
				result.put("user", user);
				/*
				 * 리턴 형식
				 * {
				 * 		token : jwt,
				 * 		user : {
				 * 			userID : 유저의 아이디 ,
				 * 			username : 유저의 이름
				 *  	}
				 *  }
				 *	의 형태로 리턴됨
				 */
				return new Gson().toJson(result);
			} else {
				//로그인 실패
				 response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				 return null;
			}
		} catch (Exception e) {
			//아이디 존재 안함
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			return null;
		}
	}

	@RequestMapping(value="/regist", method=RequestMethod.POST)
	public String regist(@RequestBody UserEntity userEntity,HttpServletResponse response) {
		//회원가입
		try {
			boolean result = userService.registUser(userEntity); //회원가입 성공하면 true 실패하면 false
			if (result) {
				//회원가입 성공
				response.setStatus(HttpServletResponse.SC_OK);
				return null;
			} else {
				//회원가입 실패
				response.setStatus(HttpServletResponse.SC_FORBIDDEN);
				return null;
			}
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return null;
		}
	}
}
