package com.timeline.api.forresponse;

import lombok.Getter;

@Getter
public class CommentResponse {
	
	private long commentID;
	
	private long articleID;
	
	private long userID;
	
	private String username;
	
	private String profile;
	
	private String content;
	
	private long createdtime;

	public CommentResponse setCommentID(long commentID) {
		this.commentID = commentID;
		return this;
	}
	
	public CommentResponse setArticleID(long articleID) {
		this.articleID = articleID;
		return this;
	}

	public CommentResponse setUserID(long userID) {
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

	public CommentResponse setCreatedtime(long createdtime) {
		this.createdtime = createdtime;
		return this;
	}

}
