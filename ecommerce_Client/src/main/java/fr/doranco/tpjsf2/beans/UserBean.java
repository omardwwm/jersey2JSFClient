package fr.doranco.tpjsf2.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.doranco.tpjsf2.entity.User;

@ManagedBean(name = "userbean")
@SessionScoped
public class UserBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(name = "prenom", value = "Michel")
	public String prenom;
	
	@ManagedProperty(name = "nom", value = "DUPOND")
	public String nom;
	
	@ManagedProperty(name = "genre", value = "homme")
	public String genre;
	
	public String datedenaissance;
	
	@ManagedProperty(name = "email", value = "michel.dupont@doranco.fr")
	public String email;

	public String niveaudeservice;

	public UserBean() {
	}
	
	private static final List<User> userList = new ArrayList<User>(Arrays.asList(
		new User("Benoît", "Leclerc", "homme", "27/10/1977", "benoit@doranco.fr", "medium"),
		new User("Paul", "Andrieux", "homme", "12/06/1965", "paul.augustin@doranco.fr", "medium"),
		new User("Laura", "Treich", "femme", "07/10/1987", "laura@doranco.fr", "medium"),
		new User("Nathalie", "Tango", "femme", "17/07/1980", "nathalie@doranco.fr", "premium"))
		);
	
	public List<User> getUserList() {
		return userList;
	}
	
	public void addAction() {
		User user = new User(this.prenom, this.nom, this.genre, this.datedenaissance, this.email, this.niveaudeservice);
		userList.add(user);
	}

	public void deleteAction(User user) {
		userList.remove(user);
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

	public String getDatedenaissance() {
		return datedenaissance;
	}

	public void setDatedenaissance(String datedenaissance) {
		this.datedenaissance = datedenaissance;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNiveaudeservice() {
		return niveaudeservice;
	}

	public void setNiveaudeservice(String niveaudeservice) {
		this.niveaudeservice = niveaudeservice;
	}

}
