package library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import library.dao.BookDAO;
import library.entity.Book;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	public BookDAO bookDAO;
	
		
	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
	public List<Book> getBooks() {
		return bookDAO.getBooks();
	}


	@Override
	@Transactional
	public void saveBook(Book theBook) {
		
		System.out.println("show book " + theBook.getCategory().getName() + " " +  theBook.getCategory().getId());
		bookDAO.saveBook(theBook);
		
	}


	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
	public Book getBook(int theId) {
		
		Book theBook = bookDAO.getBook(theId);
		
		return theBook;
	}


	@Override
	@Transactional
	public void deleteBook(int theId) {
		
		bookDAO.deleteBook(theId);
	}


/*	@Override
	@Transactional
	public List<Book> getAuthorBooks(int theId) {
		return authorDAO.getAuthorBooks(theId);
	}*/

}
