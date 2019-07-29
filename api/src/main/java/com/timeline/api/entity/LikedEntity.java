package com.timeline.api.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class LikedEntity {
	
	private int userID;
	
	private int articleID;
}
