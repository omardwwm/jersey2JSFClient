package fr.doranco.tpjsf2.control;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.core.Response;

import fr.doranco.tpjsf2.entity.Utilisateur;

public interface IUtilisateurImpl {

	List<Utilisateur> getUtilisateurs() throws SQLException;
	Utilisateur getUtilisateur(Integer id) throws SQLException;
	Response addUtilisateur(Utilisateur utilisateur) throws SQLException;
	void removeUtilisateur(Integer id)  throws SQLException;
	void updateUtilisateur(Utilisateur utilisateur)  throws SQLException;
}
