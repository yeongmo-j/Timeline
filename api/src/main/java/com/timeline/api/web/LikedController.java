package com.timeline.api.web;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.timeline.api.entity.ArticleEntity;
import com.timeline.api.entity.LikedEntity;
import com.timeline.api.service.ArticleService;
import com.timeline.api.service.LikedService;

@RestController
public class LikedController {
	
	@Autowired
	LikedService likedService;
	
	@Autowired 
	ArticleService articleService;
	
	@RequestMapping(value="/liked/{articleID}/{userID}")
	public String like(@PathVariable("articleID") int articleID, @PathVariable("userID") int userID, HttpServletResponse response) {
		try {
			LikedEntity liked = likedService.findIfExist(articleID, userID);
			ArticleEntity article = articleService.findArticle(articleID);
			if (liked!=null) {
				//존재한다는 의미이므로 취소
				likedService.deleteLike(articleID, userID);
				article.setLikeCount(article.getLikeCount()-1);
			} else {
				//새로 좋아요 만들기
				liked = new LikedEntity();
				liked.setArticleID(articleID);
				liked.setUserID(userID);
				likedService.insertLike(liked);
				article.setLikeCount(article.getLikeCount()+1);
			}
			articleService.updateArticle(article);
			response.setStatus(HttpServletResponse.SC_OK);
			return null;
		} catch(Exception e) {
			e.printStackTrace(System.out);
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return null;
		}
	}

}
