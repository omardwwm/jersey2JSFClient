package fr.doranco.tpjsf2.entity;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	public Integer id;
	public String prenom;
	public String nom;
	public String genre;
	public String dateDeNaissance;
	public String email;
	public String qualiteDeService;

	public User() {

	}

	public User(String prenom, String nom, String genre, String dateDeNaissance, String email, String qualiteDeService) {
		
		this.prenom = prenom;
		this.nom = nom;
		this.genre = genre;
		this.dateDeNaissance = dateDeNaissance;
		this.email = email;
		this.qualiteDeService = qualiteDeService;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(String dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQualiteDeService() {
		return qualiteDeService;
	}

	public void setQualiteDeService(String qualiteDeService) {
		this.qualiteDeService = qualiteDeService;
	}



}
