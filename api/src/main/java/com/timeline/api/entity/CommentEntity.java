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
@Table(name="comment")
@NoArgsConstructor
@Data
public class CommentEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(nullable=false)
	private long articleID;
	
	@Column(nullable=false)
	private long userID;
	
	@Column(nullable=false)
	private String content;
	
	@Column
    private long createdtime;
	
}
