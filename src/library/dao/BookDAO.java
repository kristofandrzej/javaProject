package library.dao;

import java.util.List;


import library.entity.Book;



public interface BookDAO {

	public List<Book> getBooks();

	public void saveBook(Book theBook);

	public Book getBook(int theId);

	public void deleteBook(int theId);

	//public List<Book> getAuthorBooks(int theId);
	
	
	
	
}
