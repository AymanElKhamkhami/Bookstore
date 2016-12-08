
import dto.RegistrationForm;
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
public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        //return User.class.equals(type);
        return RegistrationForm.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        //User user = (User) o;
        RegistrationForm form = (RegistrationForm) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user.name", "valid.name");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user.surname", "valid.surname");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user.gender", "valid.gender");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user.login", "valid.login");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user.password", "valid.password");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "valid.confirmPassword");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user.email", "valid.email");

        /*System.out.println("pass "+user.getPassword()+" , confirm "+user.getConfirmPassword());
        */
        if (!errors.hasFieldErrors("confirmPassword")) {
            if (!form.getUser().getPassword().equals(form.getConfirmPassword())) {
                errors.rejectValue("confirmPassword", "valid.confirmPasswordNotAlike");
            }
        }
        
        
    }

}
