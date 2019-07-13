package com.timeline.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.timeline.api.entity.CommentEntity;
import com.timeline.api.entity.UserEntity;
import com.timeline.api.forresponse.CommentResponse;
import com.timeline.api.repository.CommentRepository;
import com.timeline.api.repository.UserRepository;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	CommentRepository commentRepository;
	
	@Autowired
	UserRepository userRepository;
	
	/*
	 * 필요한 정보들 : 
	 * 댓글id, 소식id, 유저id, 유저이름, 유저프로필사진, 댓글 본문, 작성 시간
	 * 이 정보들을 각각 수집해서 조합해준다
	 */
	private CommentResponse formattingComment(CommentEntity comment) {
		UserEntity user = userRepository.findById(comment.getUserID());
		CommentResponse responseElement = new CommentResponse()
				.setCommentID(comment.getId())
				.setArticleID(comment.getArticleID())
				.setUserID(user.getId())
				.setUsername(user.getUsername())
				.setProfile(user.getProfile())
				.setContent(comment.getContent())
				.setCreatedtime(comment.getCreatedtime());
		return responseElement;
	}

	
	@Override
	public CommentResponse insertComment(CommentEntity commentEntity) {
		CommentEntity comment = commentRepository.save(commentEntity);
		return formattingComment(comment);
	}

	@Override
	public CommentResponse[] findByArticleID(int articleID) {
		//해당 소식에 달려있는 모든 댓글들을 리스트로 가져온다
		List<CommentEntity> commentList = commentRepository.findByArticleID(articleID);
		//해당 댓글의 개수를 가져와서 뷰에서 필요한 정보들의 클래스인 commentResponse 배열의 개수로 지정해준다
		int length = commentList.size();
		//각 댓글들을 뷰에서 필요한 정보들로 조합해준다
		CommentResponse[] formmedCommentList = new CommentResponse[length];
		for (int i=0 ; i<length ; i++) {
			CommentEntity comment = commentList.get(i);
			formmedCommentList[i] = formattingComment(comment);
		}
		return formmedCommentList;
	}

	@Override
	public void deleteAllComments(int articleID) {
		commentRepository.deleteByArticleID(articleID);
	}

	@Override
	public void deleteComment(int commentID) {
		commentRepository.deleteById(commentID);
	}

	
}
