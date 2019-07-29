package com.timeline.api.graphEntity;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CommentedEdgeProps implements Props {
	
	private String content;
}
