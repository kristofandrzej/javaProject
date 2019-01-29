package library.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import library.entity.Book;


@Repository
public class BookDAOImpl implements BookDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<Book> getBooks() {

		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query .... sort by last name
		Query<Book> theQuery = currentSession.createQuery("from Book order by title", Book.class);

		// execute query and get result list
		List<Book> books = theQuery.getResultList();		

		// return the results

		return books;

	}


	@Override
	public void saveBook(Book theBook) {
		// TODO Auto-generated method stub
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theBook);
	}


	@Override
	public Book getBook(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
						
		Book theBook = currentSession.get(Book.class, theId);
		
		return theBook;
	}


	@Override
	public void deleteBook(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();

		Query theQuery = currentSession.createQuery("delete from Book where id=:bookId");
		
		theQuery.setParameter("bookId", theId);

		theQuery.executeUpdate();
		
		
	}


/*	@Override
	public List<Book> getAuthorBooks(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query .... sort by last name
		Query<Book> theQuery = currentSession.createQuery("from Book  where id_author=:authorId", Book.class);
		
		theQuery.setParameter("authorId", theId);

		// execute query and get result list
		List<Book> books = theQuery.getResultList();
		
		for (Book book : books) {
			System.out.println("1 kniga " + book.getTitle());
		}

		// return the results
		return books;
	}*/

}
