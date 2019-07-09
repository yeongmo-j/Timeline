package com.timeline.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.timeline.api.entity.LikedEntity;
import com.timeline.api.repository.LikedRepository;

@Service
public class LikedServiceImpl implements LikedService{

	@Autowired
	LikedRepository likedRepository;
	
	@Override
	public LikedEntity findIfExist(int articleID, int userID) {
		LikedEntity liked = likedRepository.findIfExist(articleID, userID);
		return liked;
	}

	@Transactional 
	@Override
	public void deleteLike(int articleID, int userID) {
		likedRepository.deleteByArticleIDAndUserID(articleID, userID);
	}

	@Override
	public void insertLike(LikedEntity likedEntity) {
		likedRepository.save(likedEntity);
	}
	
	
}
