package com.timeline.api.service;

import org.springframework.web.multipart.MultipartFile;

public interface PhotoService {
		
	String uploadPhoto(MultipartFile file, int userID);

}
