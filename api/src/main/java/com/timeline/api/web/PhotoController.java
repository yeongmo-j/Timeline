package com.timeline.api.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.timeline.api.service.PhotoService;

//@CrossOrigin(origins="*")
@RestController
public class PhotoController {
	
	@Autowired
	PhotoService photoService;

	@RequestMapping(value="/photo/upload/{userID}", method=RequestMethod.POST)
	public String temp(@RequestParam("file") MultipartFile file, @PathVariable("userID") int userID) {
		String fileName = photoService.uploadPhoto(file, userID);
		Map<String, String> result = new HashMap<String, String>();
		result.put("name", fileName);
		result.put("statue", "done");
		
		return new Gson().toJson(result);
	}

}
