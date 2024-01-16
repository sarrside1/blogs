package com.bourguiba.myblolg.entiy;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Utilisateur {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private String username;
	private String password;
	@OneToMany(mappedBy = "utilisateur")
	private List<Article> articles;
	@OneToMany(mappedBy = "utilisateur")
	private List<Comment> comments;

}
