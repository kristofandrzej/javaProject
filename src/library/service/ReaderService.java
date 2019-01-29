package library.service;

import java.util.List;

import library.entity.Reader;



public interface ReaderService {

	public List<Reader> getReaders();

	public void saveReader(Reader theReader);

	public Reader getReader(String thelogin);
	
	public Reader getReaderByLogin(String thelogin);

	public void deleteReader(String thelogin);
	
}
