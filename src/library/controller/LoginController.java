package library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {


	@GetMapping("/showMyLoginPage")
	public String showMyLoginPage() {

		return "account-login";

	}
	
    @GetMapping("/loginError")
    public String loginError(Model theMode) {
    	
    	theMode.addAttribute("error", "true");
        return "account-login";
 
    }
	

}
