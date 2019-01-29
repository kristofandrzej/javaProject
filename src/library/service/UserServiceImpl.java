package library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import library.dao.UserDAO;
import library.entity.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	public UserDAO userDAO;
	
	@Autowired
	public BCryptPasswordEncoder passwordEncoder;
	

	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
	public List<User> getUsers() {
		
		return userDAO.getUsers();
	}


	@Override
	@Transactional
	public void saveUser(User theUser) {
		
		
		//encrypting password
	/*	theUser.setPassword("{bcrypt}" + passwordEncoder.encode(theUser.getPassword()));*/
		theUser.setPassword("{bcrypt}" + passwordEncoder.encode(theUser.getPassword()));
		
		userDAO.saveUser(theUser);
		
	}


	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
	public User getUser(String thelogin) {
		
		User theUser =	userDAO.getUser(thelogin);
		
		return theUser;
	}


	@Override
	@Transactional
	public void deleteUser(String thelogin) {

		userDAO.deleteUser(thelogin);
		
	}

}
