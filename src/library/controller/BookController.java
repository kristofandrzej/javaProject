package library.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import library.entity.Author;
import library.entity.Book;
import library.entity.Category;
import library.service.AuthorService;
import library.service.BookService;
import library.service.CategoryService;

@Controller
@RequestMapping("/book")
@Transactional
public class BookController {

	@Autowired
	private BookService bookService;

	@Autowired
	private AuthorService authorService;

	@Autowired
	private CategoryService categoryService;

	@GetMapping(value= {"/list","/",""})
	public String listBooks(Model theModel) {

		List<Book> theBooks = bookService.getBooks();

		theModel.addAttribute("books", theBooks);

		return "list-books";

	}
	
	
	//removing leading and trailing whitespace
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
		
		
	}
	
	

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		Book theBook = new Book();
		List<Author> theAuthors = authorService.getAuthors();
		List<Category> theCategories = categoryService.getCategories();

		theModel.addAttribute("book", theBook);
		theModel.addAttribute("authors", theAuthors);
		theModel.addAttribute("categories", theCategories);

		return "book-form";

	}

	@PostMapping("/saveBook")
	public String saveAuthor(@ModelAttribute("book") @Valid Book theBook, BindingResult theBindingResult, Model theModel) {
		System.out.println("Pierwsze podejscie");
		
		System.out.println("tytul: " + theBook.getTitle());
		System.out.println("imie nazwisko " );
		
		System.out.println(theBindingResult.getNestedPath());
		
		if (theBindingResult.hasErrors()) {
			
			System.out.println(theBindingResult.getFieldError());
			
			List<Author> theAuthors = authorService.getAuthors();
			List<Category> theCategories = categoryService.getCategories();

			theModel.addAttribute("authors", theAuthors);
			theModel.addAttribute("categories", theCategories);
						
			return "book-form";

		} else {
			bookService.saveBook(theBook);
			return "redirect:/book/list";
		}
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("bookId") int theId, Model theModel) {

		Book theBook = bookService.getBook(theId);

		List<Author> theAuthors = authorService.getAuthors();
		List<Category> theCategories = categoryService.getCategories();

		theModel.addAttribute("book", theBook);
		theModel.addAttribute("authors", theAuthors);
		theModel.addAttribute("categories", theCategories);

		return "book-form";

	}

	@GetMapping("/delete")
	public String deleteAuthor(@RequestParam("bookId") int theId) {

		bookService.deleteBook(theId);

		return "redirect:/book/list";

	}

	/*
	 * @GetMapping("/books") public String authorBooks(@RequestParam("authorId") int
	 * theId, Model theModel) {
	 * 
	 * Author theAuthor = authorService.getAuthor(theId);
	 * 
	 * theModel.addAttribute("author", theAuthor);
	 * 
	 * return "author-books";
	 * 
	 * }
	 */

	/*
	 * @GetMapping("/books") public String authorBooks(@RequestParam("authorId") int
	 * theId, Model theModel) {
	 * 
	 * List<Book> theAuthorBooks = authorService.getAuthorBooks(theId);
	 * 
	 * theModel.addAttribute("authorBooks", theAuthorBooks);
	 * 
	 * 
	 * return "author-books";
	 * 
	 * }
	 */

}
