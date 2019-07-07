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
import com.timeline.api.entity.ArticleEntity;
import com.timeline.api.service.ArticleService;

@RestController
public class ArticleController {
	
	@Autowired
	ArticleService articleService;
	
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
}
