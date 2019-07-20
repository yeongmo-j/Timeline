package com.timeline.api.service;

import com.timeline.api.entity.ArticleEntity;
import com.timeline.api.forresponse.ArticleResponse;

public interface ArticleService {
	/*
	 * 소식을 작성
	 */
	ArticleResponse insert(ArticleEntity articleEntity);
	
	/*
	 * 친구들의 소식들을 리스트로 불러오기
	 */
	ArticleResponse[] getTimeline(int userID);

	/*
	 * 소식 변경하기
	 */
	void updateArticle(ArticleEntity articleEntity);
	
	/*
	 * 소식 삭제하기
	 */
	void deleteArticle(int articleID);
	
	/*
	 * 홈 불러오기
	 */
	ArticleResponse[] getHomeList(int userID);
}
