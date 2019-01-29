package library.dao;

import java.util.List;

import library.entity.Authority;



public interface AuthorityDAO {

	public List<Authority> getRoles();

	public void saveUserRole(Authority userRole);

	public List<Authority> getUserRoles(String login);

	public void deleteUserRoles(String login);

	//public List<Book> getAuthorBooks(int theId);
	
	
	
	
}
