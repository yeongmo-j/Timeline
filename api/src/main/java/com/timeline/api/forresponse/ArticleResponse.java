package com.timeline.api.forresponse;

import lombok.Getter;

@Getter
public class ArticleResponse {
	
	private long articleID;
	
	private long userID;
	
	private String username;
	
	private String profile;
	
	private String content;
	
	private String[] photo;
	
	private int like;
	
	private String liked;

	private long createdtime;
	
	public ArticleResponse setArticleID(long articleID) {
		this.articleID = articleID;
		return this;
	}

	public ArticleResponse setUserID(long userID) {
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

	public ArticleResponse setLiked(String liked) {
		this.liked = liked;
		return this;
	}
	
	public ArticleResponse setCreatedtime(long createdtime) {
		this.createdtime = createdtime;
		return this;
	}
}
