package com.timeline.api.graphEntity;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class GetEdgeStep {
	
	private String label;
	
	private String direction;
	
	private int offset;
	
	private int limit;
}
