package com.bourguiba.myblolg.services;

import com.bourguiba.myblolg.entiy.Article;

public interface IArticle {

	void createArticle(Article article);
	
	Article getArticleById(int id);
	
	Iterable<Article> getArticles();
	
	Iterable<Article> getArticlesWithComment();
}
