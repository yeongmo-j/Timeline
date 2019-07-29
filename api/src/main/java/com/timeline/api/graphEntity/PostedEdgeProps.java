package com.timeline.api.graphEntity;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class PostedEdgeProps implements Props{

	private String content;
	
	private String photo;
}
