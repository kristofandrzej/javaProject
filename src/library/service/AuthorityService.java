package library.service;

import java.util.List;

import library.entity.Authority;


public interface AuthorityService{

	public List<Authority> getAuthorities();

	public void saveUserRole(Authority userRole);

	public List<Authority> getUserRole(String thelogin);

	public void deleteUserRole(String thelogin);
	
}
