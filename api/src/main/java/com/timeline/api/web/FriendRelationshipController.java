package com.timeline.api.web;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.timeline.api.entity.FriendRelationshipEntity;
import com.timeline.api.forresponse.UserResponse;
import com.timeline.api.service.FriendRelationshipService;

@RestController
public class FriendRelationshipController {
	
	@Autowired
	FriendRelationshipService friendRelationshipService;
	
	/*
	 * 공통 루틴을 하나의 메소드로 묶어 주었다.
	 * 필요한 분기는 http메소드가 무엇인가를 판별하는 것 
	 */
	private String insertAntDeleteFriend(long userID1, long userID2, HttpServletResponse response, String method) {
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
	public String insertFriend(@PathVariable long userID1, @PathVariable long userID2, HttpServletResponse response) {
		return insertAntDeleteFriend(userID1, userID2, response, "POST");
	}
	
	/*
	 * 두명의 유저ID 2개를 받아서 서로의 친구 관계를 끊어 준다
	 */
	@RequestMapping(value="/friends/{userID1}/{userID2}", method=RequestMethod.DELETE)
	public String deleteFriend(@PathVariable long userID1, @PathVariable long userID2, HttpServletResponse response) {
		return insertAntDeleteFriend(userID1, userID2, response, "DELETE");
	}
	
	/*
	 * 친구 요청을 불러와 리스트업 해준다
	 */
	@RequestMapping(value="/friend/request/{userID}", method=RequestMethod.GET)
	public String getFriendRequest(@PathVariable long userID, HttpServletResponse response) {
		try {
			UserResponse[] result = friendRelationshipService.getFriendRequest(userID);
			response.setStatus(HttpServletResponse.SC_OK);
			return new ObjectMapper().writeValueAsString(result);					
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			e.printStackTrace(System.out);
			return null;
		}
	}
	
	/*
	 * 친구 요청을 수락 혹은 거부 해준다
	 */
	@RequestMapping(value="/friend/request/response/{type}/{from}/{to}", method=RequestMethod.GET)
	public String responseToFriendRequest(@PathVariable int type, @PathVariable long from, @PathVariable long to, HttpServletResponse response) {
		//만약 type이 1이면 허용, 2면 거부
		try {
			friendRelationshipService.responseToRequest(type, from, to);
			response.setStatus(HttpServletResponse.SC_OK);
			return null;
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			e.printStackTrace(System.out);
			return null;
		}
	}
	
	/*
	 * 친구 추천을 리스트업 해준다
	 */
	@RequestMapping(value="/friend/suggest/{userID}", method=RequestMethod.GET)
	public String getFriendSuggest(@PathVariable long userID, HttpServletResponse response) {
		try {
			UserResponse[] result = friendRelationshipService.getFriendSuggest(userID);
			response.setStatus(HttpServletResponse.SC_OK);
			return new ObjectMapper().writeValueAsString(result);					
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			e.printStackTrace(System.out);
			return null;
		}
	}
	
	/*
	 * 친구 요청을 보내준다 
	 */
	@RequestMapping(value="/friend/request/{from}/{to}", method=RequestMethod.POST)
	public String sendFriendRequest(@PathVariable long from, @PathVariable long to, HttpServletResponse response) {
		try {
			friendRelationshipService.sendFriendRequest(from, to);
			response.setStatus(HttpServletResponse.SC_OK);
			return null;
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			e.printStackTrace(System.out);
			return null;
		}
	}
	
	/*
	 * 친구 검색
	 */
	@RequestMapping(value="/friend/search/{name}", method=RequestMethod.GET)
	public String searchFriend(@PathVariable String name, HttpServletResponse response) {
		try {
			UserResponse[] result = friendRelationshipService.searchFriend(name);
			response.setStatus(HttpServletResponse.SC_OK);
			return new ObjectMapper().writeValueAsString(result);					
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			e.printStackTrace(System.out);
			return null;
		}
	}

	/*
	 * 친구인지, 요청을 이미 보냈는지, 쌩 남인지 판별
	 * 친구면 1, 친구요청 이미 보낸상태면 2, 친구요청 받은 상태면 3, 아무것도 아니면 4 리턴
	 */
	@RequestMapping(value="/friend/request/check/{me}/{you}", method=RequestMethod.GET)
	public String getRelationship(@PathVariable long me, @PathVariable long you, HttpServletResponse response) {
		try {
			int relationship = friendRelationshipService.getRelationship(me, you);
			response.setStatus(HttpServletResponse.SC_OK);
			return new ObjectMapper().writeValueAsString(relationship);					
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			e.printStackTrace(System.out);
			return null;
		}
	}
}
