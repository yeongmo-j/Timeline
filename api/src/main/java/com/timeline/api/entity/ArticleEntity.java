package com.timeline.api.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ArticleEntity {	
	
	private int userID;
	
	private String content;
	
	private String photo;
}
