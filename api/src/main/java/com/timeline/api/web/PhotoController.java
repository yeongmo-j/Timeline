package com.timeline.api.web;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;

/*
 * 이미지 업로드 및 다운으로드에 사용되는 컨트롤러
 * DB와 연동 없이 단순 파일 입출력만 존재하므로, 서비스 없이 단일 컨트롤러로만 사용
 */
@RestController
public class PhotoController {

	//파일이 저장될 경로
	static final String PATH="./photos/";
	
	/*
	 * 실질적으로 파일을 저장 해주는 메소드
	 * 유저의 아이디 + 날짜 + 랜덤 값의 조합으로 파일이름을 만든 뒤, 이 이름으로 지정된 경로에 저장한다
	 * 저장이 완료된 후 저장 된 파일이름을 반환
	 * 반환된 파일이름을 프론트에서 받아서, 다른 정보들과 함께 다시 요청을 보낸다. 
	 * (해당 이미지의 파일명을 DB에 저장해서 관리하게 되는데, 
	 * 이미지 업로드와 DB에 해당 파일명 저장은 별개)
	 */
	public String uploadPhoto(MultipartFile file, int userID) throws IOException {
		String originalFileName = file.getOriginalFilename(); //확장자를 얻기 위해업로드 될 파일의 원래 이름을 받아온다.
		
		//마지막 인덱스부터 하나씩 앞으로 땡기며 처음 나오는 . 의 위치를 알아낸다. 이 뒤로 있는 문자열이 확장자가 된다. 
		int indexOfDot = originalFileName.length()-1;
		while (originalFileName.charAt(indexOfDot)!='.')
			indexOfDot--;
		
		//업로드 된 시간을 형식에 맞춰서 파일이름에 사용한다. 
		Date d = new Date();
		SimpleDateFormat formattedDate = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String formattedDateString = formattedDate.format(d);

		//파일이름 결정 = 유저 아이디 + 날짜 + 랜덤 + 확장자
		String fileName = userID + formattedDateString + (int)(Math.random()*100)+
				originalFileName.substring(indexOfDot);
		
		//파일을 경로에 저장한다. 
		byte[] data = file.getBytes();
		FileOutputStream stream = new FileOutputStream(PATH+fileName);
		stream.write(data);
		stream.close();

		return fileName; //파일이름 반환
	}
	
	
	/*
	 * 이미지 업로드 한 뒤 성공하면 파일이름을 반환.
	 * 해당 파일이름을 프론트에서 받아 다른 정보들과 함께 다시 요청을 보내 주어 DB에 저장한다
	 * 형식은
	 * {
	 * 		name : 파일이름,
	 * 		status : done
	 * }
	 * 의 형식을 json으로 반환
	 */
	@RequestMapping(value="/photo/upload/{userID}", method=RequestMethod.POST)
	public String uploadPhoto(@RequestParam("file") MultipartFile file, @PathVariable("userID") int userID, HttpServletResponse response) {
		try {
			//파일을 저장한 후, 생성된 파일이름을 받아온다
			String fileName = uploadPhoto(file, userID);
			
			//형식에 맞춰 hashmap 만들기
			Map<String, String> result = new HashMap<String, String>();
			result.put("name", fileName);
			result.put("status", "done");
			response.setStatus(HttpServletResponse.SC_OK);
			
			//json형식으로 반환
			return new Gson().toJson(result);
		} catch (Exception e) {
			e.printStackTrace(System.out);
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return null;
		}
	}
	
	/*
	 * 파일이름을 parameter로 요청이 들어오면
	 * 지정된 경로에 해당 파일이름으로 존재하는 파일을 전송해준다
	 */
	@RequestMapping(value="/photo/download", method=RequestMethod.GET)
	public void downloadPhoto(@RequestParam("filename") String fileName, HttpServletResponse response) {
		BufferedOutputStream out = null;
		InputStream in = null;
		try {
			//헤더 설정. contenttype은 image/확장자로 설정해 놓는다. 파일이름에 .은 하나이기 때문에 indexOf로 찾는다
			response.setContentType("image/"+fileName.substring(fileName.indexOf(".")+1));
			response.setHeader("Content-Disposition", "inline;filename=" + fileName);
			
			//파일 찾아서 전송해주기
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
			//스트림 닫아주기
			if(out != null){ out.flush(); }
			if(out != null){ out.close(); }
			if(in != null){ in.close(); }
			
			response.setStatus(HttpServletResponse.SC_OK);
		} catch (Exception e) {
			e.printStackTrace(System.out);
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
	}

}
