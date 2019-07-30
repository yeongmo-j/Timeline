package com.timeline.api.service;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.timeline.api.entity.FriendRelationshipEntity;
import com.timeline.api.entity.UserEntity;
import com.timeline.api.forresponse.UserResponse;
import com.timeline.api.graphEntity.CheckEdgeEntity;
import com.timeline.api.graphEntity.DeleteEdgeEntity;
import com.timeline.api.graphEntity.GetEdgeEntity;
import com.timeline.api.graphEntity.GetEdgeStep;
import com.timeline.api.graphEntity.HttpFactory;
import com.timeline.api.graphEntity.InsertEdgeEntity;
import com.timeline.api.graphEntity.RequestEdgeEntity;
import com.timeline.api.repository.UserRepository;

@SuppressWarnings("unchecked")
@Service
public class FriendRelationshipServiceImpl implements FriendRelationshipService{

	@Autowired
	HttpFactory factory;

	@Autowired
	UserRepository userRepository;

	@Override
	public void insert(FriendRelationshipEntity friendRelationshipEntity) {
		InsertEdgeEntity insertEdgeEntity = new InsertEdgeEntity();
		insertEdgeEntity.setTimestamp(factory.getTimeStamp());
		insertEdgeEntity.setLabel(factory.getFriendLabel());
		insertEdgeEntity.setFrom(friendRelationshipEntity.getUserID1());
		insertEdgeEntity.setTo(friendRelationshipEntity.getUserID2());

		List<RequestEdgeEntity> edgeList = new LinkedList<>();
		edgeList.add(insertEdgeEntity);
		factory.getRestTemplate().postForObject(factory.getInsertEdgeUrl(), edgeList, List.class);
		
		if (friendRelationshipEntity.getUserID1() != friendRelationshipEntity.getUserID2()) {
			insertEdgeEntity.setFrom(friendRelationshipEntity.getUserID2());
			insertEdgeEntity.setTo(friendRelationshipEntity.getUserID1());
			factory.getRestTemplate().postForObject(factory.getInsertEdgeUrl(), edgeList, List.class);
		}
	}

	@Override
	public void delete(FriendRelationshipEntity friendRelationshipEntity) {
		DeleteEdgeEntity deleteEdgeEntity = new DeleteEdgeEntity();
		deleteEdgeEntity.setTimestamp(factory.getTimeStamp());
		deleteEdgeEntity.setLabel(factory.getFriendLabel());
		deleteEdgeEntity.setFrom(friendRelationshipEntity.getUserID1());
		deleteEdgeEntity.setTo(friendRelationshipEntity.getUserID2());

		List<RequestEdgeEntity> edgeList = new LinkedList<>();
		edgeList.add(deleteEdgeEntity);

		factory.getRestTemplate().postForObject(factory.getDeleteEdgeUrl(), edgeList, List.class);
		
		deleteEdgeEntity.setFrom(friendRelationshipEntity.getUserID2());
		deleteEdgeEntity.setTo(friendRelationshipEntity.getUserID1());
		factory.getRestTemplate().postForObject(factory.getDeleteEdgeUrl(), edgeList, List.class);
	}

	@Override
	public UserResponse[] getFriendRequest(long userID) {
		GetEdgeEntity getEdgeEntity = new GetEdgeEntity();
		getEdgeEntity.setSrcVerticesServiceName(factory.getServiceName());
		getEdgeEntity.setSrcVerticesColumnName(factory.getUserIDColumn());
		getEdgeEntity.setSrcVerticesID(userID);

		GetEdgeStep step = new GetEdgeStep();
		step.setLabel(factory.getFriendRequestLabel());
		step.setDirection("in");
		step.setOffset(0);
		step.setLimit(20);

		getEdgeEntity.setNextStep(step);

		Map<String, Object> result = factory.getRestTemplate().postForObject(factory.getGetEdgesUrl(), getEdgeEntity, Map.class);
		int size = (int)result.get("size");
		if (size==0)
			return null;

		//결과에서 id만을 빼오기
		List<Map<String, Object>> resultList = (List<Map<String, Object>>)result.get("results");
		List<Long> requestIdList = new LinkedList<Long>();
		for (Map<String, Object> request : resultList) {
			requestIdList.add(factory.convertToLong(request.get("to")));
		}
		UserResponse[] finalResult = new UserResponse[size];

		//유저들의 아이디를 통해 정보를 불러온다
		long id;
		UserEntity user;
		UserResponse userResponse;
		for (int i=0 ; i<size ; i++) {
			id = requestIdList.get(i);
			user = userRepository.findById(id);
			userResponse = new UserResponse();
			userResponse.setId(id);
			userResponse.setUsername(user.getUsername());
			userResponse.setProfile(user.getProfile());
			userResponse.setEmail(user.getEmail());
			finalResult[i] = userResponse;
		}

		return finalResult;
	}

	@Override
	public UserResponse[] getFriendSuggest(long userID) {
		//일단 먼저 친구들의 리스트를 가져온다 -> 그다음 친구의친구 리스트를 가져온다 -> 친구의친구중에 내 친구가 아닌애들을 추천해준다
		GetEdgeEntity getEdgeEntity = new GetEdgeEntity();
		getEdgeEntity.setSrcVerticesServiceName(factory.getServiceName());
		getEdgeEntity.setSrcVerticesColumnName(factory.getUserIDColumn());
		getEdgeEntity.setSrcVerticesID(userID);

		GetEdgeStep step = new GetEdgeStep();
		step.setLabel(factory.getFriendLabel());
		step.setDirection("out");
		step.setOffset(0);
		step.setLimit(100);

		getEdgeEntity.setNextStep(step);

		Map<String, Object> result = factory.getRestTemplate().postForObject(factory.getGetEdgesUrl(), getEdgeEntity, Map.class);
		int size = (int)result.get("size");
		if (size==0)
			return null;

		//결과에서 id만을 빼오기
		List<Map<String, Object>> resultList = (List<Map<String, Object>>)result.get("results");
		Set<Long> friendSet = new HashSet<Long>();
		for (Map<String, Object> request : resultList) {
			friendSet.add(factory.convertToLong(request.get("to")));
		}
		
		//friendSet에는 현재 친구들이 담겨있음
		friendSet.add(userID); //본인도 제외해야 하므로 
		
		//이제 친구의 친구들을 가져올 차례
		getEdgeEntity.getSteps().clear();
		
		GetEdgeStep step2 = new GetEdgeStep();
		step2.setLabel(factory.getFriendLabel());
		step2.setDirection("out");
		step2.setOffset(0);
		step2.setLimit(1000);
		
		getEdgeEntity.setNextStep(step);
		getEdgeEntity.setNextStep(step2);
		
		Map<String, Object> result2 = factory.getRestTemplate().postForObject(factory.getGetEdgesUrl(), getEdgeEntity, Map.class);
		//결과에서 id만을 빼오기
		List<Map<String, Object>> resultList2 = (List<Map<String, Object>>)result2.get("results");
		List<Long> friendFriendList = new LinkedList<Long>();
		for (Map<String, Object> request : resultList2) {
			friendFriendList.add(factory.convertToLong(request.get("to")));
		}
		
		//랜덤으로 섞어준다
		Collections.shuffle(friendFriendList);
		
		
		Set<Long> finalSuggestSet = new HashSet<>();
		for (long candidate : friendFriendList) {
			if (finalSuggestSet.size()>5)
				break;
			if (!friendSet.contains(candidate)) {
				finalSuggestSet.add(candidate);
			}
		}
		if (finalSuggestSet.size()==0)
			return null;
		UserResponse[] finalResult = new UserResponse[finalSuggestSet.size()];
		//유저들의 아이디를 통해 정보를 불러온다
		UserEntity user;
		UserResponse userResponse;
		int idx = 0;
		for (long id : finalSuggestSet) {
			user = userRepository.findById(id);
			userResponse = new UserResponse();
			userResponse.setId(id);
			userResponse.setUsername(user.getUsername());
			userResponse.setProfile(user.getProfile());
			userResponse.setEmail(user.getEmail());
			finalResult[idx++] = userResponse;
		}

		return finalResult;
	}

	@Override
	public void responseToRequest(int type, long from, long to) {
		List<RequestEdgeEntity> edgeList = new LinkedList<>();
		if (type==1) {
			//수락
			//관계 맺어주기
			FriendRelationshipEntity friendRelationshipEntity = new FriendRelationshipEntity();
			friendRelationshipEntity.setUserID1(from);
			friendRelationshipEntity.setUserID2(to);
			this.insert(friendRelationshipEntity);
			
		}
		//요청 삭제하기 (공통)
		DeleteEdgeEntity deleteEdgeEntity = new DeleteEdgeEntity();
		deleteEdgeEntity.setTimestamp(factory.getTimeStamp());
		deleteEdgeEntity.setLabel(factory.getFriendRequestLabel());
		deleteEdgeEntity.setFrom(from);
		deleteEdgeEntity.setTo(to);
		edgeList.clear();
		edgeList.add(deleteEdgeEntity);
		factory.getRestTemplate().postForObject(factory.getDeleteEdgeUrl(), edgeList, String.class);
	}

	@Override
	public void sendFriendRequest(long from, long to) {
		InsertEdgeEntity insertEdgeEntity = new InsertEdgeEntity();
		insertEdgeEntity.setTimestamp(factory.getTimeStamp());
		insertEdgeEntity.setLabel(factory.getFriendRequestLabel());
		insertEdgeEntity.setFrom(from);
		insertEdgeEntity.setTo(to);
		
		List<RequestEdgeEntity> edgeList = new LinkedList<>();
		edgeList.add(insertEdgeEntity);
		factory.getRestTemplate().postForObject(factory.getInsertEdgeUrl(), edgeList, String.class);
	}

	@Override
	public UserResponse[] searchFriend(String userName) {
		List<UserEntity> findedList = userRepository.findByUserName(userName);
		if (findedList.isEmpty())
			return null;
		int size = findedList.size();
		if (size>30)
			size = 30;
		UserResponse[] result = new UserResponse[size];
		UserResponse user;
		UserEntity userEntity;
		for (int i=0 ; i<size; i++) {
			user = new UserResponse();
			userEntity = findedList.get(i);
			user.setEmail(userEntity.getEmail());
			user.setId(userEntity.getId());
			user.setProfile(userEntity.getProfile());
			user.setUsername(userEntity.getUsername());
			result[i] = user;
		}

		return result;
	}

	@Override
	public int getRelationship(long me, long you) {
		//친구면 1, 친구요청 이미 보낸상태면 2, 친구요청 받은 상태면 3, 아무것도 아니면 4 리턴
		//둘이 친구인지 확인 
		CheckEdgeEntity checkEdgeEntity = new CheckEdgeEntity();
		checkEdgeEntity.setLabel(factory.getFriendLabel());
		checkEdgeEntity.setDirection("out");
		checkEdgeEntity.setFrom(me);
		checkEdgeEntity.setTo(you);
		List<RequestEdgeEntity> edgeList = new LinkedList<>();
		edgeList.add(checkEdgeEntity);
		List<Map<String, Object>> response = (List<Map<String, Object>>)factory.getRestTemplate().postForObject(factory.getCheckEdgeUrl(), edgeList, List.class);
		if (response.size()!=0) {
			Map<String, Object> props = (Map<String, Object>)((Map<String, Object>)response.get(0)).get("props");
			if (factory.convertToLong(props.get("_lastDeletedAt"))==-1)
				return 1;
			if (factory.convertToLong(props.get("_timestamp")) > factory.convertToLong(props.get("_lastDeletedAt")))
				return 1;
		}
		
		//친구요청 이미 보낸 상태인지 확인 
		checkEdgeEntity.setLabel(factory.getFriendRequestLabel());
		response = (List<Map<String, Object>>)factory.getRestTemplate().postForObject(factory.getCheckEdgeUrl(), edgeList, List.class);
		if (response.size()!=0) {
			Map<String, Object> props = (Map<String, Object>)((Map<String, Object>)response.get(0)).get("props");
			if (factory.convertToLong(props.get("_lastDeletedAt"))==-1)
				return 2;
			if (factory.convertToLong(props.get("_timestamp")) > factory.convertToLong(props.get("_lastDeletedAt")))
				return 2;
		}
		
		//친구요청 받은 상태인지 확인
		checkEdgeEntity.setFrom(you);
		checkEdgeEntity.setTo(me);
		response = (List<Map<String, Object>>)factory.getRestTemplate().postForObject(factory.getCheckEdgeUrl(), edgeList, List.class);
		if (response.size()!=0) {
			Map<String, Object> props = (Map<String, Object>)((Map<String, Object>)response.get(0)).get("props");
			if (factory.convertToLong(props.get("_lastDeletedAt"))==-1)
				return 3;
			if (factory.convertToLong(props.get("_timestamp")) > factory.convertToLong(props.get("_lastDeletedAt")))
				return 3;
		}

		//암것도 아님
		return 4;
	}


}
