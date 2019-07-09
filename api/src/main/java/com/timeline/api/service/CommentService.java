package com.timeline.api.service;

import java.util.List;

import com.timeline.api.entity.CommentEntity;

public interface CommentService {
	
	CommentEntity insertComment(CommentEntity commentEntity);
	
	List<CommentEntity> findByArticleID(int articleID);

}
