package library.validator;



import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import library.entity.User;




@Component
public class PasswordValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return User.class.isAssignableFrom(clazz);
	}


	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
		User user = (User)target;
		
		String password = user.getPassword();
		String passwordConfirmed = user.getPasswordConfirmed();
		
				
		// Business validation
		System.out.println("validacja danych 1");
		if(!password.equals(passwordConfirmed)) {
			System.out.println("validacja danych 2");
			errors.rejectValue("password", "user.password.missMatch");
		}
		
		
		
		
	}
	
	
	
}
