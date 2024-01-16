package com.bourguiba.myblolg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bourguiba.myblolg.dtos.LoginRequest;
import com.bourguiba.myblolg.entiy.Utilisateur;
import com.bourguiba.myblolg.services.IUtilisateur;

import jakarta.servlet.http.HttpSession;

@Controller
public class UtilisateurController {
	
	@Autowired
	private IUtilisateur userService;
	
	@GetMapping("/login")
	public String index(Model model) {
		model.addAttribute("loginRequest", new LoginRequest("", ""));
		return "login";
	}
	
	@PostMapping("/login")
	public String processLogin(@ModelAttribute("loginRequest") LoginRequest loginInfos, HttpSession session) {
		
		Utilisateur user = userService.login(loginInfos);
		
		if(user != null) {
			session.setAttribute("username", user.getUsername());
			session.setAttribute("idUser", user.getId());
			return "redirect:/";
		}
		
		return "redirect:/login?error=unauthorized";
	}
}
