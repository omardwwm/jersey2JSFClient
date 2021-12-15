package fr.doranco.tpjsf2.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.doranco.tpjsf2.entity.User;

public class UserDB implements IUserDB {

	@Override
	public List<User> getUsers() throws SQLException {
		
		DorancoDS ds = new DorancoDS();

		String requete = "SELECT * FROM user";

		Connection cnx = ds.getConnection();

		Statement statement = cnx.createStatement();
		
		ResultSet rs = statement.executeQuery(requete);
		
		List<User> users = new ArrayList<User>();
		
		while(rs.next()) {
			
			User user = new User();
			
			user.setId(rs.getInt(1));
			user.setNom(rs.getString(2));
			user.setPrenom(rs.getString(3));
			user.setGenre(rs.getString(4));
			user.setDateDeNaissance(rs.getString(5));
			user.setEmail(rs.getString(6));
			user.setQualiteDeService(rs.getString(7));
			
			users.add(user);
		}

		statement.close();
		cnx.close();
		
		return users;
	}

	@Override
	public User addUser(User user) throws SQLException {

		DorancoDS ds = new DorancoDS();

		String requete = "INSERT INTO user(nom, prenom, genre, date_naissance, email, qualite_service) VALUES(?, ?, ?, ?, ?, ?)";

		Connection cnx = ds.getConnection();

		PreparedStatement ps = cnx.prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, user.getNom());
		ps.setString(2, user.getPrenom());
		ps.setString(3, user.getGenre());
		ps.setString(4, user.getDateDeNaissance());
		ps.setString(5, user.getEmail());
		ps.setString(6, user.getQualiteDeService());

		ps.executeUpdate();

		ResultSet rs = ps.getGeneratedKeys();
		if (rs.next()) {
			user.setId(rs.getInt(1));
		}
		ps.close();
		cnx.close();

		return user;
	}

	@Override
	public void removeUser(Integer id)  throws SQLException {
		
		DorancoDS ds = new DorancoDS();

		String requete = "DELETE FROM user WHERE id = " + id;

		Connection cnx = ds.getConnection();

		Statement statement = cnx.createStatement();
		
		statement.executeUpdate(requete);

		statement.close();
		cnx.close();

	}

	@Override
	public void updateUser(User user) throws SQLException {

		DorancoDS ds = new DorancoDS();

		String requete = "UPDATE user SET(nom, prenom, genre, date_naissance, email, qualite_service) VALUES(?, ?, ?, ?, ?, ?) WHERE id = ?";

		Connection cnx = ds.getConnection();

		PreparedStatement ps = cnx.prepareStatement(requete);
		ps.setString(1, user.getNom());
		ps.setString(2, user.getPrenom());
		ps.setString(3, user.getGenre());
		ps.setString(4, user.getDateDeNaissance());
		ps.setString(5, user.getEmail());
		ps.setString(6, user.getQualiteDeService());
		ps.setInt(6, user.getId());

		ps.executeUpdate();
		
		ps.close();
		cnx.close();

	}

}
