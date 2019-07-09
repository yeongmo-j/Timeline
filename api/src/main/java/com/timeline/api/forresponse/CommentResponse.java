package com.timeline.api.forresponse;

import java.time.LocalDateTime;

import lombok.Getter;

@Getter
public class CommentResponse {
	
	private int commentID;
	
	private int articleID;
	
	private int userID;
	
	private String username;
	
	private String profile;
	
	private String content;
	
	private LocalDateTime createdtime;

	public CommentResponse setCommentID(int commentID) {
		this.commentID = commentID;
		return this;
	}

	public CommentResponse setArticleID(int articleID) {
		this.articleID = articleID;
		return this;
	}

	public CommentResponse setUserID(int userID) {
		this.userID = userID;
		return this;
	}

	public CommentResponse setUsername(String username) {
		this.username = username;
		return this;
	}

	public CommentResponse setProfile(String profile) {
		this.profile = profile;
		return this;
	}

	public CommentResponse setContent(String content) {
		this.content = content;
		return this;
	}

	public CommentResponse setCreatedtime(LocalDateTime createdtime) {
		this.createdtime = createdtime;
		return this;
	}

}
