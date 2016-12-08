
import dto.AddBookForm;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ayman
 */
public class AddBookValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        //return User.class.equals(type);
        return AddBookForm.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        AddBookForm form = (AddBookForm) o;
        /*
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "book.isbn", "valid.isbn");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "book.title", "valid.title");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "book.author", "valid.author");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "book.publisher", "valid.publisher");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "book.category", "valid.category");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "book.format", "valid.format");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "book.price", "valid.price");
*/
        
    }

}
