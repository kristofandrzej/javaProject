package library.converter;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import org.springframework.stereotype.Component;

import library.entity.Author;
import library.service.AuthorService;

@Component
public class AuthorConverter implements Converter<String, Author> {

	@Autowired
	private AuthorService authorService;


	@Override
	public Author convert(String theId) {
		System.out.println("Podejscie coverters pierwsze author");
		System.out.println("oto jest Id: " + "|" + theId + "|");
		if(theId == null || theId.isEmpty()) {
			return null;
		}else {
		System.out.println("id ? " + theId);			
		return authorService.getAuthor(Integer.valueOf(theId));
	}
	}
	
	
	
}
