package com.bourguiba.myblolg.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourguiba.myblolg.dtos.LoginRequest;
import com.bourguiba.myblolg.entiy.Utilisateur;
import com.bourguiba.myblolg.repositories.UtilisateurRepository;
import com.bourguiba.myblolg.services.IUtilisateur;

@Service
public class UtilisateurImp implements IUtilisateur{
	
	@Autowired
	private UtilisateurRepository userRepo;
	@Override
	public void createUser(Utilisateur user) {
		
		userRepo.save(user);
		
	}

	@Override
	public Utilisateur login(LoginRequest loginRequest) {
		Utilisateur user = userRepo.findByUsernameAndPassword(loginRequest.getUsername(), loginRequest.getPassword());
		return user;
	}

	@Override
	public Utilisateur getUserById(int id) {
		// TODO Auto-generated method stub
		return userRepo.findById(id).get();
	}

}
