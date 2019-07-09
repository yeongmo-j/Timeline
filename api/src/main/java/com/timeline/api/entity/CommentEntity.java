package com.timeline.api.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="comment")
@NoArgsConstructor
@Data
public class CommentEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(nullable=false)
	private int articleID;
	
	@Column(nullable=false)
	private int userID;
	
	@Column(nullable=false)
	private String content;
	
	@Column
    @CreationTimestamp
    private LocalDateTime createdtime;
	
}
