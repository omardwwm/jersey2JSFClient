package fr.doranco.tpjsf2.beans;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.doranco.tpjsf2.control.IUserImpl;
import fr.doranco.tpjsf2.control.UserImpl;
import fr.doranco.tpjsf2.entity.User;

@ManagedBean(name = "userbean2")
@SessionScoped
public class UserBean2 implements Serializable {

	private static final long serialVersionUID = 1L;

	public String idUser;
	
	@ManagedProperty(name = "prenom", value = "")
	private String prenom;
	
	@ManagedProperty(name = "nom", value = "")
	private String nom;
	
	@ManagedProperty(name = "genre", value = "")
	private String genre;
	
	@ManagedProperty(name = "dateDeNaissance", value = "")
	private String dateDeNaissance;
	
	@ManagedProperty(name = "email", value = "")
	private String email;

	public String qualiteDeService;

	@ManagedProperty(name = "messageSuccess", value = "")
	private String messageSuccess = "";

	@ManagedProperty(name = "messageError", value = "")
	private String messageError = "";
	
	public UserBean2() {
	}
	
	private static final IUserImpl userImpl = new UserImpl();
	private static List<User> listUsers = getUsers();

	public List<User> getListUsers() {
		initialize();
		return listUsers;
	}

	private static List<User> getUsers() {
	
		try {
			List<User> listeUsers = userImpl.getUsers();
			return listeUsers;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String addUser() {
		initializeMessages();
		User user = new User(prenom, nom, genre, dateDeNaissance, email, qualiteDeService);
		User addedUser = null;
		try {
			addedUser = userImpl.addUser(user);
			this.idUser = addedUser.getId().toString();
			messageSuccess = "Utilisateur ajouté avec succès.";
			listUsers = getUsers();
		} catch (SQLException e) {
			messageError = "Erreur lors de l'ajout de l'utilisateur.";
			e.printStackTrace();
		}
		return "";
	}

	public String deleteUser(User user) {
		initializeMessages();
		try {
			userImpl.removeUser(user.getId());
			messageSuccess = "Utilisateur supprimé avec succès.";
			listUsers = getUsers();
		} catch (SQLException e) {
			messageError = "Erreur lors de la suppression de l'utilisateur !!";
			e.printStackTrace();
		}
		return "";
	}

	public String updateUser() {
		initializeMessages();
		try {
			User user = new User(prenom, nom, genre, dateDeNaissance, email, qualiteDeService);
			userImpl.updateUser(user);
			messageSuccess = "Utilisateur mis à jour avec succès.";
			listUsers = getUsers();
		} catch (SQLException e) {
			messageError = "Erreur lors de la mise à jour de l'utilisateur !!";
			e.printStackTrace();
		}
		return "";
	}

	public String initialize() {
		initializeMessages();
		initializeFields();
		return "";
	}
	
	private void initializeMessages() {
		messageSuccess = "";
		messageError = "";
	}

	private void initializeFields() {

		idUser = "";
		prenom = "";
		nom = "";
		genre = "Homme";
		dateDeNaissance = "";
		email = "";
		qualiteDeService ="";
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(String dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public String getQualiteDeService() {
		return qualiteDeService;
	}

	public void setQualiteDeService(String qualiteDeService) {
		this.qualiteDeService = qualiteDeService;
	}

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	public String getMessageSuccess() {
		return messageSuccess;
	}

	public String getMessageError() {
		return messageError;
	}

	public void setMessageSuccess(String messageSuccess) {
		this.messageSuccess = messageSuccess;
	}

	public void setMessageError(String messageError) {
		this.messageError = messageError;
	}

}
