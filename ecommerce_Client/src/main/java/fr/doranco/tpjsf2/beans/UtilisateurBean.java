package fr.doranco.tpjsf2.beans;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.doranco.tpjsf2.control.IUtilisateurImpl;
import fr.doranco.tpjsf2.control.UtilisateurImpl;
import fr.doranco.tpjsf2.entity.Utilisateur;
import fr.doranco.tpjsf2.utils.Dates;

@ManagedBean(name = "utilisateurbean")
@SessionScoped
public class UtilisateurBean implements Serializable {

//	private final static String CHARSET = ";charset=UTF-8";
	private static final long serialVersionUID = 1L;

	@ManagedProperty(name = "nom", value = "")
	public String nom;

	@ManagedProperty(name = "prenom", value = "")
	public String prenom;

	@ManagedProperty(name = "dateNaissance", value = "")
	public String dateNaissance;

	@ManagedProperty(name = "isActif", value = "")
	public Boolean isActif;
	
	@ManagedProperty(name = "profil", value = "")
	public String profil;

	@ManagedProperty(name = "email", value = "")
	public String email;

	@ManagedProperty(name = "password", value = "")
	public String password;

	@ManagedProperty(name = "telephone", value = "")
	public String telephone;

	
	public UtilisateurBean() {}
	
	private static final IUtilisateurImpl utilisateurImpl = new UtilisateurImpl(); 
	private static List<Utilisateur> utilisateurs = getAllUtilisateurs();
	private Utilisateur utilisateur = new Utilisateur();
	
	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	public List<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}

	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		UtilisateurBean.utilisateurs = utilisateurs;
	}
	
	public static List<Utilisateur> getAllUtilisateurs() {
		try {
			List<Utilisateur> utilisateurs = utilisateurImpl.getUtilisateurs();
			return utilisateurs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String addUtilisateur() {
		Utilisateur utilisateur = new Utilisateur(nom, prenom, Dates.stringToDate(dateNaissance), isActif, profil, email, password,
				telephone);
//		Utilisateur addedUtilisateur = null;
		try {
			utilisateurImpl.addUtilisateur(utilisateur);
			utilisateurs = getAllUtilisateurs();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return "";
	}
	
	public String getOneUtilisateur(Utilisateur utilisateur) {
		try {
			utilisateur = utilisateurImpl.getUtilisateur(utilisateur.getId());
			this.utilisateur = utilisateur;
			return "detailUtilisateur";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(this.utilisateur);
		return "";
	}
//	public String detail(Utilisateur utilisateur) {
//		this.utilisateur = utilisateur;
//		return "detailUtilisateur";
//	}
	
	public String deleteUser(Utilisateur utilisateur) {
		try {
			utilisateurImpl.removeUtilisateur(utilisateur.getId());
			utilisateurs = getAllUtilisateurs();
			return "deleteUtilisateur";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "";
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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getIsActif() {
		return isActif;
	}

	public void setIsActif(Boolean isActif) {
		this.isActif = isActif;
	}

	public String getProfil() {
		return profil;
	}

	public void setProfil(String profil) {
		this.profil = profil;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	
}
