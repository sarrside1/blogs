package com.bourguiba.myblolg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bourguiba.myblolg.entiy.Article;
import com.bourguiba.myblolg.entiy.Comment;
import com.bourguiba.myblolg.entiy.Utilisateur;
import com.bourguiba.myblolg.services.IArticle;
import com.bourguiba.myblolg.services.IComment;
import com.bourguiba.myblolg.services.IUtilisateur;

import jakarta.servlet.http.HttpSession;

@Controller
public class CommentController {
	
	@Autowired
	private IUtilisateur userService;
	@Autowired
	private IComment commentService;
	
	@Autowired
	private IArticle articleService;

	@PostMapping("/comment/{idArticle}")
	public String createComment(
			@RequestParam("text") String text,
			@PathVariable("idArticle") int idArticle, HttpSession session) {
		
		Utilisateur userComment = userService.getUserById((int)session.getAttribute("idUser"));
		Article articleComment = articleService.getArticleById(idArticle);
		
		Comment comment = new Comment();
		comment.setText(text);
		comment.setArticle(articleComment);
		comment.setUtilisateur(userComment);
		
		commentService.createComment(comment);
		
		return "redirect:/";
	}
}
