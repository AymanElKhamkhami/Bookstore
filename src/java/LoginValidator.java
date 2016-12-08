
import dto.LoginForm;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.ValidationUtils;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ayman
 */
public class LoginValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return LoginForm.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "valid.password");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailOrLogin", "valid.emailorlogin");

        
    }

}
