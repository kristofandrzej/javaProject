package library.dao;

import java.util.List;

import library.entity.Author;
import library.entity.Book;



public interface AuthorDAO {

	public List<Author> getAuthors();

	public void saveAuthor(Author theAuthor);

	public Author getAuthor(int theId);

	public void deleteAuthor(int theId);

	public List<Book> getAuthorBooks(int theId);
	
	
	
	
}
