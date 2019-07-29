package com.timeline.api.graphEntity;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class DeleteVertexEntity implements RequestEdgeEntity{
	
	private long id;
	
	private long timestamp;

}
