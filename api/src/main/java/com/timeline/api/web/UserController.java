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


/*
 * 유저 로그인 및 회원가입의 요청 시에 사용되는 컨트롤러로써,
 * 유저의 정보는 UserEntity에 매핑된 인스턴스가 사용된다
 */
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private JwtService jwtService;
	
	/*
	 * 로그인 요청
	 * 로그인이 성공하면, 유저 정보와 생성된 토큰을 반환한다. 
	 */
	@RequestMapping(value="/login", method=RequestMethod.POST, produces="text/plain;charset=UTF-8")
	public String login(@RequestBody UserEntity userEntity, HttpServletResponse response) {
		try {
			UserEntity findedUser = userService.login(userEntity); // 로그인 성공하면 Entity 반환 실패하면 null 반환
			if (findedUser != null) {
				//로그인 성공
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
				Map<String, Object> user = new HashMap<>();
				//이름과 아이디 찾아서 넣어주기
				user.put("userID", findedUser.getId());
				user.put("username", findedUser.getUsername());
				//토큰 받아서 넣어주기
				Map<String, Object> result = new HashMap<>();
				result.put("token", jwtService.makeJwt(findedUser));
				result.put("user", user);
				
				response.setStatus(HttpServletResponse.SC_OK);
				//json반환
				return new Gson().toJson(result);
			} else {
				//로그인 실패 : 비밀번호 불일치 혹은 이메일이 존재하지 않음
				 response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				 return null;
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return null;
		}
	}

	/*
	 * 회원가입 요청
	 */
	@RequestMapping(value="/regist", method=RequestMethod.POST, produces="text/plain;charset=UTF-8")
	public String regist(@RequestBody UserEntity userEntity,HttpServletResponse response) {
		try {
			UserEntity result = userService.registUser(userEntity); //회원가입  실패하면 null
			if (result != null) {
				//회원가입 성공
				response.setStatus(HttpServletResponse.SC_OK);
				return null;
			} else {
				//회원가입 실패
				response.setStatus(HttpServletResponse.SC_FORBIDDEN);
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return null;
		}
	}
}
