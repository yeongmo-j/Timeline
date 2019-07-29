package com.timeline.api.web;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.timeline.api.entity.CommentEntity;
import com.timeline.api.forresponse.CommentResponse;
import com.timeline.api.service.CommentService;

@RestController
public class CommentController {
	
	@Autowired
	CommentService commentService;
		
	/*
	 * 해당 소식에 새로운 댓글을 저장 하는 요청
	 * 필요한 정보들을 받아 그대로 저장해준다
	 * 저장된 코멘트를 뷰에서 필요한 정보들과 함께 조합해서
	 * json으로 반환
	 */
	@RequestMapping(value="/comment", method=RequestMethod.POST, produces="text/plain;charset=UTF-8")
	public String insertArticle(@RequestBody CommentEntity commentEntity, HttpServletResponse response) {
		try {
			//저장
			CommentResponse savedComment = commentService.insertComment(commentEntity);
			response.setStatus(HttpServletResponse.SC_OK);
			return new Gson().toJson(savedComment);
		} catch (Exception e) {
			e.printStackTrace(System.out);
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return null;
		}
	}
	
	/*
	 * 해당 소식에 달려있는 모든 댓글들을
	 * 뷰에서 필요한 정보들과 함께 조합해서 
	 * json으로 반환
	 */
	@RequestMapping(value="/comment/{articleID}", method=RequestMethod.GET, produces="text/plain;charset=UTF-8")
	public String getComments(@PathVariable long articleID, HttpServletResponse response) {
		try {
			CommentResponse[] formmedCommentList = commentService.findByArticleID(articleID);
			//json으로 반환
			response.setStatus(HttpServletResponse.SC_OK);
			return new Gson().toJson(formmedCommentList);
		} catch (Exception e) {
			e.printStackTrace(System.out);
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return null;
		}
	}
	
	
	/*
	 * 해당 댓글 하나를 삭제 해준다.
	 * 댓글의 id만을 받아준다
	 */
	@RequestMapping(value="/comment/{commentID}", method=RequestMethod.DELETE)
	public String deleteComment(@PathVariable long commentID, HttpServletResponse response) {
		try {
			commentService.deleteComment(commentID);
			response.setStatus(HttpServletResponse.SC_OK);
			return null;
		} catch (Exception e) {
			e.printStackTrace(System.out);
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return null;
		}
	}
}
