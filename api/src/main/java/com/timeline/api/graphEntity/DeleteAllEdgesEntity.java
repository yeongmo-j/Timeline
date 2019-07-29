package com.timeline.api.graphEntity;

import java.util.LinkedList;
import java.util.List;

import lombok.Data;

@Data
public class DeleteAllEdgesEntity implements RequestEdgeEntity{
	
	private List<Long> ids;
	
	private String label;
	
	private String direction;
	
	private long timestamp;
	
	public DeleteAllEdgesEntity(){
		ids = new LinkedList<Long>();
	}
}
