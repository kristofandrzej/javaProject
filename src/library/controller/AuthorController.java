package library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import library.entity.Author;
import library.entity.Book;
import library.service.AuthorService;

@Controller
@RequestMapping("/author")
public class AuthorController {

	@Autowired
	private AuthorService authorService;

	@GetMapping(value= {"/list","/",""})
	public String listAuthors(Model theModel) {

		List<Author> theAuthors = authorService.getAuthors();

		theModel.addAttribute("authors", theAuthors);

		return "list-authors";

	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		Author theAuthor = new Author();

		theModel.addAttribute("author", theAuthor);

		return "author-form";

	}

	@PostMapping("/saveAuthor")
	public String saveAuthor(@ModelAttribute("author") Author theAuthor) {

		authorService.saveAuthor(theAuthor);

		return "redirect:/author/list";

	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("authorId") int theId, Model theModel) {

		Author theAuthor = authorService.getAuthor(theId);

		theModel.addAttribute("author", theAuthor);

		return "author-form";

	}

	@GetMapping("/delete")
	public String deleteAuthor(@RequestParam("authorId") int theId) {

		authorService.deleteAuthor(theId);

		return "redirect:/author/list";

	}

	@GetMapping("/books")
	public String authorBooks(@RequestParam("authorId") int theId, Model theModel) {

		Author theAuthor = authorService.getAuthor(theId);

		theModel.addAttribute("author", theAuthor);

		return "author-books";

	}

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
