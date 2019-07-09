package com.timeline.api.web;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.timeline.api.entity.CommentEntity;
import com.timeline.api.entity.UserEntity;
import com.timeline.api.forresponse.CommentResponse;
import com.timeline.api.service.CommentService;
import com.timeline.api.service.UserService;

@RestController
public class CommentController {
	
	@Autowired
	CommentService commentService;
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/comment/insert", method=RequestMethod.POST)
	public String insertArticle(@RequestBody CommentEntity commentEntity, HttpServletResponse response) {
		try {
			commentService.insertComment(commentEntity);
			response.setStatus(HttpServletResponse.SC_OK);
			return null;
		} catch (Exception e) {
			e.printStackTrace(System.out);
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return null;
		}
	}
	
	@RequestMapping(value="/comment/get/{articleID}", method=RequestMethod.GET, produces="text/plain;charset=UTF-8")
	public String getComments(@PathVariable int articleID, HttpServletResponse response) {
		try {
			List<CommentEntity> commentList = commentService.findByArticleID(articleID);
			int length = commentList.size();
			CommentResponse[] formmedCommentList = new CommentResponse[length];
			for (int i=0 ; i<length ; i++) {
				CommentEntity comment = commentList.get(i);
				UserEntity user = userService.findById(comment.getUserID());
				CommentResponse responseElement = new CommentResponse()
						.setCommentID(comment.getId())
						.setArticleID(articleID)
						.setUserID(user.getId())
						.setUsername(user.getUsername())
						.setProfile(user.getProfile())
						.setContent(comment.getContent())
						.setCreatedtime(comment.getCreatedtime());
				formmedCommentList[i] = responseElement;
			}
			response.setStatus(HttpServletResponse.SC_OK);
			return new Gson().toJson(formmedCommentList);
		} catch (Exception e) {
			e.printStackTrace(System.out);
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return null;
		}
	}

}
