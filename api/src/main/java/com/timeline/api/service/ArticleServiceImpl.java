package com.timeline.api.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.timeline.api.entity.ArticleEntity;
import com.timeline.api.repository.ArticleRepository;

public class ArticleServiceImpl implements ArticleService {
	
	@Autowired
	ArticleRepository articleRepository;

	@Override
	public void insert(ArticleEntity articleEntity) {
		articleRepository.save(articleEntity);
	}
}
