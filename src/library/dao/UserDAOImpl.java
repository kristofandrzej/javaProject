package library.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import library.entity.Book;
import library.entity.User;


@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	

	@Override
	public List<User> getUsers() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query .... sort by last name
		Query<User> theQuery = currentSession.createQuery("from User order by login", User.class);

		// execute query and get result list
		List<User> users = theQuery.getResultList();		

		// return the results
		return users;
	}


	@Override
	public void saveUser(User theUser) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theUser);
	}


	@Override
	public User getUser(String login) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		User theUser = currentSession.get(User.class, login);
		
		return theUser;
	}


	@Override
	public void deleteUser(String login) {
		
		Session currentSession = sessionFactory.getCurrentSession();

		Query theQuery = currentSession.createQuery("delete from User where login=:login");
		
		theQuery.setParameter("login", login);

		theQuery.executeUpdate();
		
		
	}



}
