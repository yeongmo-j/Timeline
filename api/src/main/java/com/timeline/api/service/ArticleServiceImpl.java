package com.timeline.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.timeline.api.entity.ArticleEntity;
import com.timeline.api.repository.ArticleRepository;
import com.timeline.api.repository.UserRepository;

@Service
public class ArticleServiceImpl implements ArticleService {
	
	@Autowired
	ArticleRepository articleRepository;
	
	@Override
	public ArticleEntity insert(ArticleEntity articleEntity) {
		return articleRepository.save(articleEntity);
	}
	
	@Override
	public List<ArticleEntity> getFriendsArticle(int userID) {
		List<ArticleEntity> friendsArticlesList = articleRepository.getFriendsArticles(userID);
		return friendsArticlesList;
	}
}
