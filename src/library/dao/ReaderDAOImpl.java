package library.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import library.entity.Book;
import library.entity.Reader;
import library.entity.User;


@Repository
public class ReaderDAOImpl implements ReaderDAO {

	@Autowired
	private SessionFactory sessionFactory;
	

	@Override
	public List<Reader> getReaders() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query .... sort by last name
		Query<Reader> theQuery = currentSession.createQuery("from Reader order by login", Reader.class);

		// execute query and get result list
		List<Reader> readers = theQuery.getResultList();		

		// return the results
		return readers;
	}


	@Override
	public void saveReader(Reader theReader) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theReader);
	}


	@Override
	public Reader getReader(String login) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Reader theReader = currentSession.get(Reader.class, login);
	
		return theReader;
	}


	@Override
	public void deleteReader(String login) {
		
		Session currentSession = sessionFactory.getCurrentSession();

		Query theQuery = currentSession.createQuery("delete from Reader where login=:login");
		
		theQuery.setParameter("login", login);

		theQuery.executeUpdate();
		
		
	}
	
	@Override
	public Reader getReaderByLogin(String login) {
		
		Session currentSession = sessionFactory.getCurrentSession();

		Query theQuery = currentSession.createQuery("from Reader where login=:login");
		
		theQuery.setParameter("login", login);
		
		Reader theReader = (Reader) theQuery.getSingleResult();
		
		return theReader;
		
	}



}
