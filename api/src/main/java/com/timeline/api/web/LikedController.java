package com.timeline.api.web;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.timeline.api.service.LikedService;

@RestController
public class LikedController {
	
	@Autowired
	LikedService likedService;
		
	/*
	 * 해당 소식(게시글)에 좋아요를 설정/취소 하는 요청
	 * 선택지가 상호적인 두가지 밖에 없기 때문에, 소식의 id와 유저의 id 정보만을 get요청으로 받아주고
	 * 해당 요청이 좋아요 설정인지 취소인지는 알아서 판단 해준다
	 */
	@RequestMapping(value="/liked/{articleID}/{userID}", method=RequestMethod.PUT)
	public String like(@PathVariable("articleID") int articleID, @PathVariable("userID") int userID, HttpServletResponse response) {
		try {
			likedService.likeOrUnlike(articleID, userID);
			response.setStatus(HttpServletResponse.SC_OK);
			return null;
		} catch(Exception e) {
			e.printStackTrace(System.out);
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return null;
		}
	}

}
