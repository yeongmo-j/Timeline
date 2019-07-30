package com.timeline.api.graphEntity;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import lombok.Data;

@Data
public class GetEdgeEntity implements RequestEdgeEntity{
	
	private LinkedList<Map<String, Object>> srcVertices;
	
	private LinkedList<Map<String, LinkedList<GetEdgeStep>>> steps;
	
	public GetEdgeEntity(){
		srcVertices = new LinkedList<Map<String, Object>>();
		srcVertices.add(new HashMap<String, Object>());
		steps = new LinkedList<Map<String, LinkedList<GetEdgeStep>>>();
		
	}
	
	public void setSrcVerticesServiceName(String serviceName) {
		srcVertices.get(0).put("serviceName", serviceName);
	}
	
	public void setSrcVerticesColumnName(String columnName) {
		srcVertices.get(0).put("columnName", columnName);
	}
	
	public void setSrcVerticesID(long id) {
		srcVertices.get(0).put("id", id);
	}
	
	public void setNextStep(GetEdgeStep nextStep) {
		LinkedList<GetEdgeStep> nextStepList = new LinkedList<GetEdgeStep>();
		nextStepList.add(nextStep);
		Map<String, LinkedList<GetEdgeStep>> step = new HashMap<String, LinkedList<GetEdgeStep>>();
		step.put("step", nextStepList);
		steps.addLast(step);
	}
}
