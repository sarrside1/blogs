package com.bourguiba.myblolg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bourguiba.myblolg.entiy.Utilisateur;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer>{
	
	Utilisateur findByUsernameAndPassword(String username, String password);
}
