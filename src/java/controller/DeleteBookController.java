/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.BookDAO;
import model.pojo.Book;
import model.util.HibernateUtil;
import org.hibernate.Session;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;
import service.UserService;

/**
 *
 * @author Ayman
 */
@SuppressWarnings("deprecation")
public class DeleteBookController extends SimpleFormController {

    private UserService userService;

    public DeleteBookController() {
        setCommandClass(Book.class);
        setCommandName("book");
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {

        Book book = (Book) command;
        System.out.println(book.getIsbn());
        
        try {
            BookDAO.deleteBook(book);
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(book);
            session.getTransaction().commit();
            return new ModelAndView(new RedirectView("bookdeleted.htm"));
            
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelAndView(new RedirectView("adderror.htm"));
        }

    }

}
