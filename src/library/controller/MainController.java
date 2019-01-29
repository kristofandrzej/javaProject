package library.controller;


import java.security.Principal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import library.entity.Book;
import library.entity.Order;
import library.entity.OrderItem;
import library.entity.Reader;
import library.service.Cart;
import library.service.OrderItemService;
import library.service.OrderService;
import library.service.ReaderService;

@Controller
@Transactional
@RequestMapping(value= {"/","index"})
public class MainController {
	
	@Autowired
	private Cart shoopingCart;
	
	@Autowired 
	private ReaderService readerService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private OrderItemService orderItemService;

	@GetMapping(value= {"/","index",""})
	public String home(Model theModel) {
			
		List<Book> theChoosenBooks = shoopingCart.getBooks();

		theModel.addAttribute("choosenBooks", theChoosenBooks);		
		
        return "index";
}
	
	@GetMapping(value= "orderingCart")
	public String orderingCart(Model theModel) {
			
		List<Book> theChoosenBooks = shoopingCart.getBooks();

		theModel.addAttribute("choosenBooks", theChoosenBooks);		
		
        return "ordering-cart";
}
	
	@GetMapping("orderingCart/removeFromCart")
	public String removeFromShoppingCart(@RequestParam("choosenBookId") int theId, Model theModel) {
		
		shoopingCart.deleteBook(theId);
	
		return "redirect:/orderingCart";
		
	}
	
	@GetMapping("orderingCart/orderBooks")
	public String orderBooks(Model theModel, Principal principal) {
		
		List<Book> theChoosenBooks = shoopingCart.getBooks();
		
		// setting reader object
		String nameLogin = principal.getName();
		System.out.println("To jest kontroller: " + nameLogin);
		System.out.println("Sprawdzian gdzie sie wypiepsza");
		Reader theReader = readerService.getReaderByLogin(nameLogin);
		System.out.println("Sprawdzian gdzie sie wypiepsza II");
		System.out.println(theReader.getFirstName() + " " + "id " + theReader.getId());
		
		System.out.println("Sprawdzian gdzie sie wypiepsza III");
		// creating new Order and setting the object properties
		Order theNewOrder = new Order(); 
		theNewOrder.setReader(theReader);
		
		System.out.println("Sprawdzian gdzie sie wypiepsza IV");
		System.out.println("To jest id readera" + " " + theNewOrder.getReader().getId() + " a to login " + theNewOrder.getReader().getLogin());
		theNewOrder.setDateOrder(LocalDate.now());
		theNewOrder.setDateReceipt(LocalDate.now().plusDays(2));
		theNewOrder.setStatus("Pending");
		
		System.out.println("Sprawdzian gdzie sie wypiepsza V");
		System.out.println("Dane: " + " data order " + theNewOrder.getDateOrder() + " data receipt " + theNewOrder.getDateReceipt() + " id readera " + theNewOrder.getReader().getId() + theNewOrder.getStatus());
		
		orderService.saveOrder(theNewOrder);
	
		System.out.println("Petla");
		for (Book book : theChoosenBooks) {
			
			OrderItem tempOrderItem = new OrderItem();
			
			tempOrderItem.setOrder(theNewOrder);
			tempOrderItem.setBook(book);
			tempOrderItem.setPlannedReturnDate(LocalDate.now().plusDays(7));
		
			
			System.out.println("Petla przed ");
			
			orderItemService.saveOrderItem(tempOrderItem);
			
			System.out.println("Petla po ");
			
			tempOrderItem = null;
			
		}
		
		
		return "order-confirmation";
	}
	
}
