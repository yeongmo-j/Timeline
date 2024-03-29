package com.timeline.api.service;

public interface LikedService {

	/*
	 * 해당 유저가 해당 게시글에 좋아요를 눌렀었는지, 안눌렀었는지를 판단 후
	 * 눌렀으면, 좋아요를 취소하고 안눌렀으면, 좋아요를 처리해준다. 
	 */
	void likeOrUnlike(long articleID, long userID);
	
	/*
	 * 해당 사용자가 해당 소식에 좋아요를 눌렀는지 안눌렀는지를 리턴
	 */
	boolean heOrSheLikesIt(long articleID, long userID);
	
	/*
	 * 해당 글에 좋아요를 누른 사람 수가 몇인지
	 */
	int howManyLikes(long articleID);
}
