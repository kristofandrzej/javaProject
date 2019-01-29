package library.dao;

import java.util.List;

import library.entity.Reader;


public interface ReaderDAO {

	public List<Reader> getReaders();

	public void saveReader(Reader theReader);

	public Reader getReader(String login);

	public void deleteReader(String login);
	
	public Reader getReaderByLogin(String login);

	//public List<Book> getAuthorBooks(int theId);
	
	
	
	
}
