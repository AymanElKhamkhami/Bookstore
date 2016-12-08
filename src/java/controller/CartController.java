/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.dao.BookDAO;
import model.dao.CartDAO;
import model.pojo.Book;
import model.pojo.User;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author Ayman
 */
public class CartController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {

        ModelAndView mv;
        HttpSession session = hsr.getSession();
        User user = (User) session.getAttribute("sessionuser");

        mv = new ModelAndView("usercart");

        try {
            //delete a book if delete is pressed
            Book book;
            List<Book> list = BookDAO.listBooks();
            if (hsr.getParameter("deleteBook") != null) {
                int isbn = Integer.parseInt(hsr.getParameter("deleteBook"));
                CartDAO.deleteBookFromCart(isbn, user);
            }
            ////
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            
            if ((hsr.getParameter("isbn") != null) && (hsr.getParameter("qtty") != null)) {
                int isbn = Integer.parseInt(hsr.getParameter("isbn"));
                int quantity = Integer.parseInt(hsr.getParameter("qtty"));
                Date date = Calendar.getInstance().getTime();

                CartDAO.addBookToCart(user, isbn, quantity, date);
            }

            List<Book> books = CartDAO.listBooksInCart(user);
            mv.addObject("books", books);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return mv;

    }

}
