package com.bourguiba.myblolg.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bourguiba.myblolg.entiy.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer>{
	
	
	@Query("SELECT DISTINCT a FROM Article a LEFT JOIN FETCH a.utilisateur LEFT JOIN FETCH a.comments")
    List<Article> findWithUserAndComments();

}
