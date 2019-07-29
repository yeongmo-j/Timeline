package com.timeline.api.graphEntity;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class DeleteEdgeEntity implements RequestEdgeEntity{
	
	private long timestamp;
	
	private long from;
	
	private long to;

	private String label;
}
