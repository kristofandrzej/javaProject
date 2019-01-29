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
//@RequestMapping("/account")
public class AccountController {


	@GetMapping("/account")
	public String account(Model theModel) {

		return "account";

	}
	

}
