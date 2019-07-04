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
@Table(name="article")
@NoArgsConstructor
@Data
public class ArticleEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(nullable=false)
	private int userID;
	
	@Column(nullable=false)
	private String content;
	
	@Column
	private String photo;
	
	@Column
	private int like;

}
