package com.timeline.api.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CommentEntity {
	
	private long articleID;
	
	private long userID;
	
	private String content;
	
	private long createdtime;
		
}
