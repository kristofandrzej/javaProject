package library.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import library.entity.Book;


@Component
@Scope(
	value=WebApplicationContext.SCOPE_SESSION,
	proxyMode=ScopedProxyMode.TARGET_CLASS)
public class Cart {
	
	@Autowired
	BookService bookService;
	
	private List<Book> books;
	
	public Cart() {
		books = new ArrayList<Book>();
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	public void addBook(int theId) {
		System.out.println("Operacja dodawania ksiazki");
		Book theBook = bookService.getBook(theId);
		System.out.println("Mamy ksiazke: " + theBook.getTitle());
		books.add(theBook);
		System.out.println("dodalismy do listy");
	}
	
	public void deleteBook(int theId) {
		System.out.println("Operacja usuwania ksiazki ksiazki");
		Book theBook = bookService.getBook(theId);
		System.out.println("Operacja usuwania ksiazki ksiazki - mamy juz id");
		System.out.println("Tytul: " + theBook.getTitle());
		for(Book book : books) {
			System.out.println("Petla ksiazek : " + book.getTitle());
			if(Integer.valueOf(book.getId()).equals(Integer.valueOf(theBook.getId()))) {
				System.out.println("Operacja usuwania ksiazki ksiazki - usuwanie");
				books.remove(books.indexOf(book));
				System.out.println("Po usuniêciu");
				break;
				
				}
			
		}
		
	
		
	}
	
	
}
