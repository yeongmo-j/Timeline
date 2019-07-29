package com.timeline.api.graphEntity;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import lombok.Data;

@Component
@Data
public class HttpFactory {

	private HttpComponentsClientHttpRequestFactory factory;
	
	private final String serviceName = "timeline";

    private final String graphUrl = "http://localhost:9000/";
    
    private final String insertEdgeUrl = graphUrl + "graphs/edges/insertWithWait";
    
    private final String checkEdgeUrl = graphUrl + "graphs/checkEdges";
    
    private final String getEdgesUrl = graphUrl + "graphs/getEdges";
    
    private final String deleteEdgeUrl = graphUrl + "graphs/edges/deleteWithWait";
    
    private final String deleteAllEdgeUrl = graphUrl + "graphs/edges/deleteAllWithWait";
        
    private final String userIDColumn = "user_id";
    
    private final String articleIDColumn = "article_id";
    
    private final String postedLabel = "posted3";
    
    private final String commentedLabel = "commented2";
    
    private final String likedLabel = "liked2";
    
    private final String fiendLabel = "friend2";
    
    private final long maximumTimeStamp = 9999999999999l;
    
    private long primaryID;
	
	public HttpFactory () {
		//출처 : https://sjh836.tistory.com/141
		factory = new HttpComponentsClientHttpRequestFactory();
		factory.setReadTimeout(5000); //ms
		factory.setConnectTimeout(5000);
		HttpClient httpClient = HttpClientBuilder.create()
				.setMaxConnTotal(100) //ip+포트 연결 제한
				.setMaxConnPerRoute(100) //최대 커넥션
				.build();
		factory.setHttpClient(httpClient);
		//RestTemplate restTemplate = new RestTemplate(factory);
		primaryID = (this.getTimeStamp()%10000000)/100;
	}
	
	public RestTemplate getRestTemplate() {
		return new RestTemplate(this.factory);
	}
	
	public long getTimeStamp() {
		return System.currentTimeMillis();
	}
	
	public String timeToDate(long timeStamp) {
		return new java.text.SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(timeStamp); 
	}
	
	public long getAutoIncreasedID() {
		return ++primaryID;
	}
	
	public long convertToLong(Object num) {
		if (num instanceof Long) {
			return (long) num;
		} else {
			return new Long((int)num);
		}
	}
}
