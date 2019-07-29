package com.timeline.api.graphEntity;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CheckEdgeEntity implements RequestEdgeEntity {
	
	private String label;
	
	private String direction;
	
	private long from;
	
	private long to;

}
