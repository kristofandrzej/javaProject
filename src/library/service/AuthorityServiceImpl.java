package library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import library.dao.AuthorityDAO;
import library.entity.Authority;
import library.entity.User;

@Service
@Transactional
public class AuthorityServiceImpl implements AuthorityService {

	@Autowired
	public AuthorityDAO authorityDAO;
	
	

	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
	public List<Authority> getAuthorities() {
	
		return authorityDAO.getRoles();
		
	}


	@Override
	@Transactional
	public void saveUserRole(Authority userRole) {

		authorityDAO.saveUserRole(userRole);
		
		
	}


	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
	public List<Authority> getUserRole(String thelogin) {

		
		return authorityDAO.getUserRoles(thelogin);
	}


	@Override
	@Transactional
	public void deleteUserRole(String thelogin) {
		
		authorityDAO.deleteUserRoles(thelogin);
		
	}

}
