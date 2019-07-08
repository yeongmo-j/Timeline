package com.timeline.api.forresponse;

import java.time.LocalDateTime;

import lombok.Getter;

@Getter
public class ArticleResponse {
	
	private int articleID;
	
	private int userID;
	
	private String username;
	
	private String profile;
	
	private String content;
	
	private String[] photo;
	
	private int like;
	
	private boolean liked;

	private LocalDateTime createdtime;
	
	public ArticleResponse setArticleID(int articleID) {
		this.articleID = articleID;
		return this;
	}

	public ArticleResponse setUserID(int userID) {
		this.userID = userID;
		return this;
	}

	public ArticleResponse setUsername(String username) {
		this.username = username;
		return this;
	}

	public ArticleResponse setProfile(String profile) {
		this.profile = profile;
		return this;
	}

	public ArticleResponse setContent(String content) {
		this.content = content;
		return this;
	}

	public ArticleResponse setPhoto(String photos) {
		if (photos == null)
			this.photo = null;
		else
			this.photo = photos.split("/");
		return this;
	}

	public ArticleResponse setLike(int like) {
		this.like = like;
		return this;
	}

	public ArticleResponse setLiked(boolean liked) {
		this.liked = liked;
		return this;
	}
	
	public ArticleResponse setCreatedtime(LocalDateTime createdtime) {
		this.createdtime = createdtime;
		return this;
	}
}
