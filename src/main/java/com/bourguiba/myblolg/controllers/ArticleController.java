package com.bourguiba.myblolg.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bourguiba.myblolg.entiy.Article;
import com.bourguiba.myblolg.entiy.Utilisateur;
import com.bourguiba.myblolg.services.IArticle;
import com.bourguiba.myblolg.services.IUtilisateur;

import jakarta.servlet.http.HttpSession;

@Controller
public class ArticleController {
	
	@Autowired
	private IArticle articleService;
	@Autowired
	private IUtilisateur userService;
	
	@GetMapping("/")
	public String index(Model model) {
		Iterable<Article> articles = articleService.getArticlesWithComment();
		model.addAttribute("articles", articles);
		return "index";
	}
	
	
	@GetMapping("/create")
	public String createArticle() {
		return "create-article";
	}
	
	@PostMapping("/create")
	public String createArticleProcess(
			@RequestParam("titre") String titre,
			@RequestParam("contenu") String contenu,
			@RequestParam("image") MultipartFile file,
			HttpSession session
			) {
		
		String uploadFolder = "/Users/sidesarr/workspaceBourguiba/myblog-1/src/main/resources/static/uploads";
        // Save the file to the folder
        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        String filePath = Paths.get(uploadFolder, fileName).toString();
        try {
            Files.copy(file.getInputStream(), Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        
        if(session.getAttribute("idUser") == null)
        	return "redirect:/login?errorMessage=Veuillez vous connecter!";
        
        Utilisateur userPosting = userService.getUserById((int)session.getAttribute("idUser"));
        
        Article newArticle = new Article();
        
        newArticle.setContenue(contenu);
        newArticle.setTitre(titre);
        newArticle.setImage("/uploads/"+fileName);
        newArticle.setUtilisateur(userPosting);
        
        articleService.createArticle(newArticle);
        
		return "redirect:/";
	}
}
