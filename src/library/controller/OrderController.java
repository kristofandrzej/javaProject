package library.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import library.entity.Order;
import library.entity.OrderItem;
import library.entity.Reader;
import library.service.AuthorService;
import library.service.CategoryService;
import library.service.OrderItemService;
import library.service.OrderService;
import library.service.ReaderService;

@Controller
@RequestMapping("/order")
@Transactional
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private OrderItemService orderItemService;
	
	@Autowired
	private ReaderService readerService;

	@Autowired
	private AuthorService authorService;

	@Autowired
	private CategoryService categoryService;

	@GetMapping(value= {"/history","/",""})
	public String listBooks(Model theModel,  Principal principal) {

		// setting reader object
		String nameLogin = principal.getName();
		System.out.println("Check 0 checking name " + nameLogin );
		Reader theReader = readerService.getReaderByLogin(nameLogin);
		System.out.println("Check 1 getting reader ID: ");
		int theReaderId = theReader.getId();
		System.out.println("Check 2 reader Id : " + theReader.getId());
		
		List<Order> readerOrders = orderService.getReaderOrders(theReaderId);
		
		for (Order order : readerOrders) {
			System.out.println("Data: " + order.getStatus());
		}

		theModel.addAttribute("orders", readerOrders);

		return "order-history";

	}
	
	@GetMapping("/showOrderItems")
	public String showOrderItems(@RequestParam("orderId") int theOrderId, Model theModel) {

		List<OrderItem> theOrderItems = orderItemService.getSpecificOrderItems(theOrderId);

		theModel.addAttribute("orderItems", theOrderItems);

		return "order-items";

	}
	
	@GetMapping("/all-orders")
	public String allOrders(Model theModel) {
		
		List<Order> allOrders = orderService.getOrders();
		
		theModel.addAttribute("allOrders", allOrders);
		
		return "manage-orders";
	}
	
	@GetMapping("/showOrderItemsLib")
	public String showOrderItemsLib(@RequestParam("orderId") int theOrderId, Model theModel) {

		List<OrderItem> theOrderItems = orderItemService.getSpecificOrderItems(theOrderId);

		theModel.addAttribute("orderItems", theOrderItems);

		return "manage-order-items";

	}
	
/*	
	//removing leading and trailing whitespace
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
		
		
	}
	
	

	@GetMapping("/showOrderItems")
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



	@GetMapping("/delete")
	public String deleteAuthor(@RequestParam("bookId") int theId) {

		bookService.deleteBook(theId);

		return "redirect:/book/list";

	}*/

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
