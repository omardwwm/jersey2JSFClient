package fr.doranco.tpjsf2.control;

import java.sql.SQLException;
import java.util.List;

import fr.doranco.tpjsf2.entity.User;
import fr.doranco.tpjsf2.model.IUserDB;
import fr.doranco.tpjsf2.model.UserDB;

public class UserImpl implements IUserImpl {

	private final IUserDB userDB = new UserDB();

	@Override
	public List<User> getUsers() throws SQLException {
		
		return userDB.getUsers();
	}

	@Override
	public User addUser(User user) throws SQLException {

		return userDB.addUser(user);
	}

	@Override
	public void removeUser(Integer id)  throws SQLException {
		
		userDB.removeUser(id);

	}

	@Override
	public void updateUser(User user) throws SQLException {
		
		userDB.updateUser(user);
	}

}
