package com.timeline.api.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.timeline.api.entity.ArticleEntity;
import com.timeline.api.entity.UserEntity;
import com.timeline.api.forresponse.ArticleResponse;
import com.timeline.api.service.ArticleService;
import com.timeline.api.service.UserService;

@RestController
public class ArticleController {

	@Autowired
	ArticleService articleService;

	@Autowired
	UserService userService;

	@RequestMapping(value="/article/insert", method=RequestMethod.POST)
	public String insertArticle(@RequestBody ArticleEntity articleEntity, HttpServletResponse response) {
		try {
			ArticleEntity savedEntity = articleService.insert(articleEntity);
			response.setStatus(HttpServletResponse.SC_OK);
			Map<String,Integer> map = new HashMap<String,Integer>();
			map.put("articleID", savedEntity.getId());
			return new Gson().toJson(map);
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return null;
		}
	}

	@RequestMapping(value="/article/getarticles", method=RequestMethod.GET)
	public String insertArticle(@RequestParam int userID, HttpServletResponse response) {
		try {
			List<ArticleEntity> friendsArticlesList = articleService.getFriendsArticle(userID);
			int length = friendsArticlesList.size();
			ArticleResponse[] formmedArticleList = new ArticleResponse[length];
			for (int i=0 ; i<length ; i++) {
				ArticleEntity article = friendsArticlesList.get(i);
				UserEntity user = userService.findById(article.getUserID());
				ArticleResponse responseElement = new ArticleResponse()
						.setArticleID(article.getId())
						.setUserID(article.getUserID())
						.setUsername(user.getUsername()) //여기 다시 설정
						.setProfile(user.getProfile()) //여기 다시 설정
						.setContent(article.getContent())
						.setPhoto((article.getPhoto()==null || article.getPhoto().equals("")) ? null : article.getPhoto()) //null일 경우 처리
						.setLike(article.getLikeCount())
						.setLiked(false) //여기 다시 설정
						.setCreatedtime(article.getCreatedtime());
				formmedArticleList[i] = responseElement;
			}
			response.setStatus(HttpServletResponse.SC_OK);
			return new Gson().toJson(formmedArticleList);
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			e.printStackTrace(System.out);
			return null;
		}
	}
}
