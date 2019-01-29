package library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import library.dao.ReaderDAO;
import library.entity.Reader;

@Service
@Transactional
public class ReaderServiceImpl implements ReaderService {

	@Autowired
	public ReaderDAO readerDAO;
	


	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
	public List<Reader> getReaders() {
		
		return readerDAO.getReaders();
	}


	@Override
	@Transactional
	public void saveReader(Reader theReader) {

		readerDAO.saveReader(theReader);
		
	}


	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
	public Reader getReader(String thelogin) {
	
		Reader theReader = readerDAO.getReader(thelogin);
		
		System.out.println("Wlasnie wzywa readera po loginie2");
		
		return theReader;
		
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
	public Reader getReaderByLogin(String thelogin) {
	
		Reader theReader = readerDAO.getReaderByLogin(thelogin);
		
		System.out.println("Wlasnie wzywa readera po loginie");
		
		return theReader;
		
	}
	
	


	@Override
	@Transactional
	public void deleteReader(String thelogin) {
		
		readerDAO.deleteReader(thelogin);
		
	}

}
