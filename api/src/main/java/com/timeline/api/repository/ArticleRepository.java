package com.timeline.api.repository;

import org.springframework.data.repository.CrudRepository;

import com.timeline.api.entity.ArticleEntity;

public interface ArticleRepository extends CrudRepository<ArticleEntity, Integer>{

}
