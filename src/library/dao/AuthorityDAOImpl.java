package library.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import library.entity.Authority;
import library.entity.User;


@Repository
public class AuthorityDAOImpl implements AuthorityDAO {

	@Autowired
	private SessionFactory sessionFactory;
	



	@Override
	public List<Authority> getRoles() {
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query .... sort by last name
		Query<Authority> theQuery = currentSession.createQuery("from Authority order by login", Authority.class);

		// execute query and get result list
		List<Authority> userRoles = theQuery.getResultList();		

		// return the results
		return userRoles;
	}


	@Override
	public void saveUserRole(Authority userRole) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(userRole);
	}


	@Override
	public List<Authority> getUserRoles(String login) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query .... sort by last name
		Query<Authority> theQuery = currentSession.createQuery("from Authority order by login", Authority.class);

		// execute query and get result list
		List<Authority> theUserRoles = theQuery.getResultList();		

		// return the results
		return theUserRoles;
	}


	@Override
	public void deleteUserRoles(String login) {
		
		Session currentSession = sessionFactory.getCurrentSession();

		Query theQuery = currentSession.createQuery("delete from Authority where login=:login");
		
		theQuery.setParameter("login", login);

		theQuery.executeUpdate();
		
		
	}



}
