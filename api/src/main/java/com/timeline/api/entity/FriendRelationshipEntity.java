package com.timeline.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="friendrelationship")
@NoArgsConstructor
@Data
public class FriendRelationshipEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(nullable=false)
	private int userID1;
	
	@Column(nullable=false)
	private int userID2;
	
	/*
	 * 일단 저장할 때 회원 1과 2가 서로 친구라면, {1,2}, {2,1} 이렇게 저장한다
	 * 중복이 생기지만, 나중에 쿼리날릴 때 힘들꺼같음
	 */

}
