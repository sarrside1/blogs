package com.bourguiba.myblolg.services;

import com.bourguiba.myblolg.dtos.LoginRequest;
import com.bourguiba.myblolg.dtos.LoginRequest;
import com.bourguiba.myblolg.entiy.Utilisateur;

public interface IUtilisateur {
	
	void createUser(Utilisateur user);
	Utilisateur login(LoginRequest loginRequest);
	Utilisateur getUserById(int id);
}
