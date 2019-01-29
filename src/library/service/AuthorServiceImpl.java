package library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import library.dao.AuthorDAO;
import library.entity.Author;
import library.entity.Book;

@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	public AuthorDAO authorDAO;
	
		
	@Override
	@Transactional
	public List<Author> getAuthors() {
		return authorDAO.getAuthors();
	}


	@Override
	@Transactional
	public void saveAuthor(Author theAuthor) {
		
		authorDAO.saveAuthor(theAuthor);
		
	}


	@Override
	@Transactional
	public Author getAuthor(int theId) {
		
		Author theAuthor = authorDAO.getAuthor(theId);
		
		return theAuthor;
	}


	@Override
	@Transactional
	public void deleteAuthor(int theId) {
		
		authorDAO.deleteAuthor(theId);
	}


	@Override
	@Transactional
	public List<Book> getAuthorBooks(int theId) {
		return authorDAO.getAuthorBooks(theId);
	}

}
