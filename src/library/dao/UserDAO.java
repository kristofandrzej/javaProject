package library.dao;

import java.util.List;

import library.entity.User;



public interface UserDAO {

	public List<User> getUsers();

	public void saveUser(User theUsers);

	public User getUser(String login);

	public void deleteUser(String login);

	//public List<Book> getAuthorBooks(int theId);
	
	
	
	
}
