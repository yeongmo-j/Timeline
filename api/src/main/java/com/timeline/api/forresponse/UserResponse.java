package com.timeline.api.forresponse;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class UserResponse {
	
	private long id;
	
	private String email;
		
	private String username;
	
	private String profile;

}
