package library.controller;

import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import library.entity.Authority;
import library.entity.Reader;
import library.entity.User;
import library.service.AuthorityService;
import library.service.ReaderService;
import library.service.UserService;
import library.validator.PasswordValidator;

@Controller
@Transactional
public class RegisterController {

	@Autowired
	private UserService userService;

	@Autowired
	private ReaderService readerService;
	
	@Autowired
	private AuthorityService authorityService;
	
	@Autowired
	private PasswordValidator passwordValidator;
	

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegisterForm(Model theModel) {

		System.out.println("To ten powinnien diza³aæ");
		User theUser = new User();
		Reader theReader = new Reader();

		theModel.addAttribute("user", theUser);
		theModel.addAttribute("reader", theReader);

		return "register";
	}

	@RequestMapping(value = "registerUser", method = RequestMethod.POST)
	public String registerUser(@ModelAttribute("user") @Valid User theUser, BindingResult theBindingResult, @ModelAttribute("reader") @Valid Reader theReader, BindingResult theBindingResult2, Model theModel) {

		System.out.println("proba 1: ");

		// System.out.println("first name i last name:  " + theReader.getFirstName() + " " + theReader.getLastName());
		System.out.println("The user password:  " + theUser.getPassword() + "confirm pass " + theUser.getPasswordConfirmed());

		System.out.println(theBindingResult.getFieldError());
		
		passwordValidator.validate(theUser, theBindingResult);

		if (theBindingResult.hasErrors() || theBindingResult2.hasErrors()) {
			System.out.println("ma bledy");
			// wyswietlic komunikat do zaogowania jeszcze raz z bledami
			// w formularzu specjalny input form na hasla
			
			
			
			return "register";

		} else {

			// zapisac uzytkownika i reader i wyswietlic formularz do logowania
			// servis do zaladowania bazy danych
			// hasla z encoderem
			
			System.out.println("Zapisujemy do bazy");
			userService.saveUser(theUser);
			readerService.saveReader(theReader);
			
			// save default user authorities
			Authority userRole = new Authority();
			userRole.setLogin(theUser.getLogin());
			userRole.setAuthority("ROLE_READER");
			
			authorityService.saveUserRole(userRole);
			
/*			// automatically loging 
			Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
			grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_READER"));
						
			UserDetails userDetails = new org.springframework.security.core.userdetails.User(theUser.getLogin(), theUser.getPassword(), grantedAuthorities);
			
			securityService.autologin(userDetails, theUser.getPassword());
			
			System.out.println("A o to i detale " + userDetails.getUsername() + " " + userDetails.getPassword());
			System.out.println("Zwracamy ");*/
			
			
			return "redirect:/showMyLoginPage";
		}
	
	
	}
}
