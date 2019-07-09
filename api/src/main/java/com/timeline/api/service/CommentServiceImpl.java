package com.timeline.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.timeline.api.entity.CommentEntity;
import com.timeline.api.repository.CommentRepository;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	CommentRepository commentRepository;
	
	@Override
	public CommentEntity insertComment(CommentEntity commentEntity) {
		return commentRepository.save(commentEntity);
	}

	@Override
	public List<CommentEntity> findByArticleID(int articleID) {
		return commentRepository.findByArticleID(articleID);
	}
	
}
