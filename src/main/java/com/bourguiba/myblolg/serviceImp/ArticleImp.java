package com.bourguiba.myblolg.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourguiba.myblolg.entiy.Article;
import com.bourguiba.myblolg.repositories.ArticleRepository;
import com.bourguiba.myblolg.services.IArticle;

@Service
public class ArticleImp implements IArticle{
	
	@Autowired
	private ArticleRepository articleRepo;

	@Override
	public void createArticle(Article article) {
		articleRepo.save(article);
		
	}

	@Override
	public Iterable<Article> getArticles() {
		
		return articleRepo.findAll();
	}

	@Override
	public Iterable<Article> getArticlesWithComment() {
		// TODO Auto-generated method stub
		return articleRepo.findWithUserAndComments();
	}

	@Override
	public Article getArticleById(int id) {
		// TODO Auto-generated method stub
		return articleRepo.findById(id).get();
	}

}
