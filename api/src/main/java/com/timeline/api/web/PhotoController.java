package com.timeline.api.web;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.timeline.api.service.PhotoService;

@RestController
public class PhotoController {

	@Autowired
	PhotoService photoService;

	static final String PATH="./photos/";
	
	@RequestMapping(value="/photo/upload/{userID}", method=RequestMethod.POST)
	public String uploadPhoto(@RequestParam("file") MultipartFile file, @PathVariable("userID") int userID, HttpServletResponse response) {
		try {
			String fileName = photoService.uploadPhoto(file, userID);
			Map<String, String> result = new HashMap<String, String>();
			result.put("name", fileName);
			result.put("statue", "done");
			response.setStatus(HttpServletResponse.SC_OK);
			return new Gson().toJson(result);
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return null;
		}
	}
	
	@RequestMapping(value="/photo/download", method=RequestMethod.GET)
	public void downloadPhoto(@RequestParam("filename") String fileName, HttpServletResponse response) {
		BufferedOutputStream out = null;
		InputStream in = null;
		try {
			response.setContentType("image/"+fileName.substring(fileName.indexOf(".")+1));
			response.setHeader("Content-Disposition", "inline;filename=" + fileName);
			File file = new File(PATH+fileName);
			if (file.exists()) {
				in = new FileInputStream(file);
				out = new BufferedOutputStream(response.getOutputStream());
				int len;
				byte[] buf = new byte[1024];
				while ( (len = in.read(buf)) > 0) {
					out.write(buf, 0, len);
				}
			}
			if(out != null){ out.flush(); }
			if(out != null){ out.close(); }
			if(in != null){ in.close(); }
		} catch (Exception e) {
			e.printStackTrace(System.out);
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
	}

}
