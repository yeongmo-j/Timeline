package com.timeline.api.web;

import java.util.HashMap;
import java.util.Map;

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
		ArticleEntity savedEntity = articleService.insert(articleEntity);
		response.setCode("200");
		response.setResult("positive");
		//결과로 data에 저장된 articleID를 넣어서 보내줌
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("articleID", savedEntity.getId());
		response.setData(map);
		return new Gson().toJson(response);
	}
		

}
