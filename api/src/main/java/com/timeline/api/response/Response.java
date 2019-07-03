package com.timeline.api.response;

import java.util.HashMap;
import java.util.Map;

public class Response {
	private Map<String, Object> status;
	
	private Object data;
	
	public Response(){
		status = new HashMap<>();
		data = null;
	}
	
	public Response setCode(String code) {
		status.put("code", code);
		return this;
	}
	
	public Response setResult(String result) {
		status.put("result", result);
		return this;
	}
	
	public Response setData(Object data) {
		this.data = data;
		return this;
	}
	
}
