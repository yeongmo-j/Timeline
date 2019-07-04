package com.timeline.api.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.timeline.api.entity.ArticleEntity;
import com.timeline.api.response.Response;
import com.timeline.api.service.ArticleService;

@CrossOrigin(origins = "*")
@RestController
public class ArticleController {
	
	@Autowired
	ArticleService articleService;
	
	@RequestMapping(value="/article/insert", method=RequestMethod.POST)
	public String insertArticle(@RequestBody ArticleEntity articleEntity) {
		Response response = new Response();
		articleService.insert(articleEntity);
		response.setCode("200");
		response.setResult("positive");
		return new Gson().toJson(response);
	}
	
	@RequestMapping(value="/article/insertPhoto", method=RequestMethod.POST)
	public String insertPhoto() {
		//사진 등록
	}

}
