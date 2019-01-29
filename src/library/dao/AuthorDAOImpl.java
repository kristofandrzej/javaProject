package library.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import library.entity.Author;
import library.entity.Book;


@Repository
public class AuthorDAOImpl implements AuthorDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<Author> getAuthors() {

		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query .... sort by last name
		Query<Author> theQuery = currentSession.createQuery("from Author order by lastName", Author.class);

		// execute query and get result list
		List<Author> authors = theQuery.getResultList();
		
		for (Author author : authors) {
			for (Book book : author.getBooks())
			System.out.println("Ksiazki: " + book.getTitle());
		}

		// return the results

		return authors;

	}


	@Override
	public void saveAuthor(Author theAuthor) {
		// TODO Auto-generated method stub
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theAuthor);
	}


	@Override
	public Author getAuthor(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
						
		Author theAuthor = currentSession.get(Author.class, theId);
		
		return theAuthor;
	}


	@Override
	public void deleteAuthor(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();

		Query theQuery = currentSession.createQuery("delete from Author where id=:authorId");
		
		theQuery.setParameter("authorId", theId);

		theQuery.executeUpdate();
		
		
	}


	@Override
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
	}

}
