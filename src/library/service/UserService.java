package library.service;

import java.util.List;


import library.entity.User;


public interface UserService {

	public List<User> getUsers();

	public void saveUser(User theUser);

	public User getUser(String thelogin);

	public void deleteUser(String thelogin);
	
}
