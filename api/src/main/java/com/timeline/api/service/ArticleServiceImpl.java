package com.timeline.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.timeline.api.entity.ArticleEntity;
import com.timeline.api.repository.ArticleRepository;

@Service
public class ArticleServiceImpl implements ArticleService {
	
	@Autowired
	ArticleRepository articleRepository;

	@Override
	public ArticleEntity insert(ArticleEntity articleEntity) {
		return articleRepository.save(articleEntity);
	}
}
