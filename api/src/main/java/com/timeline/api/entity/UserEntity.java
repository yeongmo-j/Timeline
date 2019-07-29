package com.timeline.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="user")
@NoArgsConstructor
@Data
public class UserEntity {
	@Id
	private long id;
	
	@Column(nullable=false)
	private String email;
		
	@Column(nullable=false)
	private String username;
	
	@Column(nullable=false)
	private String password;
	
	@Column(nullable=false)
	private String question;
	
	@Column(nullable=false)
	private String answer;
	
	@Column
	private String profile;

}
