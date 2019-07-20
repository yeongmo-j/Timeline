package com.timeline.api.web;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.timeline.api.entity.ArticleEntity;
import com.timeline.api.forresponse.ArticleResponse;
import com.timeline.api.service.ArticleService;
import com.timeline.api.service.CommentService;
import com.timeline.api.service.LikedService;
import com.timeline.api.service.UserService;

@RestController
public class ArticleController {

	@Autowired
	ArticleService articleService;

	@Autowired
	UserService userService;
	
	@Autowired
	LikedService likedService;
	
	@Autowired
	CommentService commentService;

	/*
	 * 소식 작성이 입력으로 들어오는 요청 
	 * 들어온 소식을 DB에 저장 해준 후, 뷰에서 필요로 하는 정보들로 조합 해서 json형식으로 리턴 해준다. 
	 */
	@RequestMapping(value="/article", method=RequestMethod.POST, produces="text/plain;charset=UTF-8")
	public String insertArticle(@RequestBody ArticleEntity articleEntity, HttpServletResponse response) {
		try {
			ArticleResponse responseElement = articleService.insert(articleEntity);
			response.setStatus(HttpServletResponse.SC_OK);
			return new Gson().toJson(responseElement);
		} catch (Exception e) {
			e.printStackTrace(System.out);
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return null;
		}
	}
	
	/*
	 * 본인이 본인의 소식을 삭제
	 * 삭제의 과정은 1.소식 삭제 -> 2.해당 좋아요 전체 삭제 -> 3.해당 소식의 모든 댓글 삭제 로 이루어진다. 
	 */
	@RequestMapping(value="/article/{articleID}", method=RequestMethod.DELETE)
	public String deleteArticle(@PathVariable int articleID, HttpServletResponse response) {
		try {
			//삭제
			articleService.deleteArticle(articleID);
			response.setStatus(HttpServletResponse.SC_OK);
			return null;
		} catch(Exception e) {
			e.printStackTrace(System.out);
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return null;
		}
	}

	/*
	 * 친구들의 소식을 불러와서 
	 * 뷰에서 원하는 형식의 데이터 형태로 가공 해서
	 * 
	 */
	@RequestMapping(value="/article/timeline/{userID}", method=RequestMethod.GET, produces="text/plain;charset=UTF-8")
	public String getTimelineList(@PathVariable int userID, HttpServletResponse response) {
		try {
			ArticleResponse[] formmedArticleList = articleService.getTimeline(userID);
			response.setStatus(HttpServletResponse.SC_OK);
			return new Gson().toJson(formmedArticleList);
		} catch (Exception e) {
			e.printStackTrace(System.out);
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return null;
		}
	}
	
	
	/*
	 * 자신 혹은 친구의 홈 불러오기 
	 */
	@RequestMapping(value="/article/home/{userID}", method=RequestMethod.GET, produces="text/plain;charset=UTF-8")
	public String getHomeList(@PathVariable int userID, HttpServletResponse response) {
		try {
			ArticleResponse[] formmedArticleList = articleService.getHomeList(userID);
			response.setStatus(HttpServletResponse.SC_OK);
			return new Gson().toJson(formmedArticleList);
		} catch (Exception e) {
			e.printStackTrace(System.out);
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return null;
		}
	}
	
}
