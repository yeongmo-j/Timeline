package com.timeline.api.web;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.timeline.api.entity.FriendRelationshipEntity;
import com.timeline.api.service.FriendRelationshipService;

@RestController
public class FriendRelationshipController {
	
	@Autowired
	FriendRelationshipService friendRelationshipService;
	
	/*
	 * 공통 루틴을 하나의 메소드로 묶어 주었다.
	 * 필요한 분기는 http메소드가 무엇인가를 판별하는 것 
	 */
	private String insertAntDeleteFriend(int userID1, int userID2, HttpServletResponse response, String method) {
		try {
			//엔티티를 하나 생성해줘서 값을 바인딩 해 준다
			FriendRelationshipEntity friendRelationshipEntity = new FriendRelationshipEntity();
			friendRelationshipEntity.setUserID1(userID1);
			friendRelationshipEntity.setUserID2(userID2);
			
			//친구 관계 저장 혹은 삭제 수행
			if (method.equals("POST"))
				friendRelationshipService.insert(friendRelationshipEntity);
			else if (method.equals("DELETE"))
				friendRelationshipService.delete(friendRelationshipEntity);
			else
				throw new Exception("Http method error");
			response.setStatus(HttpServletResponse.SC_OK);
			return null;
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return null;
		}
	}
	
	/*
	 * 두명의 유저ID 2개를 받아서 서로가 서로에게 친구 관계를 맺어 준다
	 */
	@RequestMapping(value="/friends/{userID1}/{userID2}", method=RequestMethod.POST)
	public String insertFriend(@PathVariable int userID1, @PathVariable int userID2, HttpServletResponse response) {
		return insertAntDeleteFriend(userID1, userID2, response, "POST");
	}
	
	/*
	 * 두명의 유저ID 2개를 받아서 서로의 친구 관계를 끊어 준다
	 */
	@RequestMapping(value="/friends/{userID1}/{userID2}", method=RequestMethod.DELETE)
	public String deleteFriend(@PathVariable int userID1, @PathVariable int userID2, HttpServletResponse response) {
		return insertAntDeleteFriend(userID1, userID2, response, "DELETE");
	}
	
}
