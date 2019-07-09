package com.timeline.api.service;

import java.util.List;

import com.timeline.api.entity.ArticleEntity;

public interface ArticleService {
	
	ArticleEntity insert(ArticleEntity articleEntity);
	
	List<ArticleEntity> getFriendsArticle(int userID);

	ArticleEntity findArticle(int articleID);
	
	void updateArticle(ArticleEntity articleEntity);
}
