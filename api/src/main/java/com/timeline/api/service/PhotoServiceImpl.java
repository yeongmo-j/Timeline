package com.timeline.api.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class PhotoServiceImpl implements PhotoService{
	
	static final String PATH="./photos/";
	
	@Override
	public String uploadPhoto(MultipartFile file, int userID) {
		String fileName = userID+makeFileName()+file.getOriginalFilename();
		try {
			saveFile(file, fileName);
		} catch (IOException e) {
			//오류처리
		}
		
		return fileName;
	}
	
	private String makeFileName() {
		Date d = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		return format.format(d);
	}
	
	private void saveFile(MultipartFile file, String fileName) throws IOException {
		byte[] data = file.getBytes();
		FileOutputStream stream = new FileOutputStream(PATH+fileName);
		stream.write(data);
		stream.close();
	}
}
