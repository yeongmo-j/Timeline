package com.timeline.api.service;

import com.timeline.api.entity.CommentEntity;
import com.timeline.api.forresponse.CommentResponse;

public interface CommentService {
	
	/*
	 * 새로운 댓글을 해당 글에 새로 삽입
	 */
	CommentResponse insertComment(CommentEntity commentEntity);
	
	/*
	 * 해당 글에 달려있는 모든 댓글들을 리스트로 반환한다
	 */
	CommentResponse[] findByArticleID(long articleID);

	/*
	 * 해당 글을 삭제 할 때 모든 댓글들도 삭제 해줘야 한다
	 */
	void deleteAllComments(long articleID);
	
	/*
	 * 해당 글의 해당 댓글을 삭제
	 */
	void deleteComment(long commentID);
}
