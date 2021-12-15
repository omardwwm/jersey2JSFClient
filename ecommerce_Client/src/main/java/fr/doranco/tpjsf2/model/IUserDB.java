package fr.doranco.tpjsf2.model;

import java.sql.SQLException;
import java.util.List;

import fr.doranco.tpjsf2.entity.User;

public interface IUserDB {

	List<User> getUsers() throws SQLException;
	User addUser(User user) throws SQLException;
	void removeUser(Integer id)  throws SQLException;
	void updateUser(User user) throws SQLException;
	
}
