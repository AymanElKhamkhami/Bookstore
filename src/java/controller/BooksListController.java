/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
@SuppressWarnings("deprecation")
public class BooksListController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {

        //setting controller depending on the user type
        ModelAndView mv;
        HttpSession session = hsr.getSession();
        User u = (User) session.getAttribute("sessionuser");

        if (u.getLogin().equals("admin")) {
            mv = new ModelAndView("books"); //the name of the .jsp view

            Book book;

            try {
                List<Book> list = BookDAO.listBooks();
                if (hsr.getParameter("deleteBook") != null) {
                    for (Book b : list) {
                        if (b.getIsbn() == Integer.parseInt(hsr.getParameter("deleteBook"))) {
                            book = b;
                            BookDAO.deleteBook(book);
                        }
                    }
                }
                if (hsr.getParameter("inputIsbn") != null) {
                    System.out.println(hsr.getParameter("inputIsbn"));
                    System.out.println(hsr.getParameter("inputTitle"));
                    System.out.println(hsr.getParameter("inputAuthor"));
                    System.out.println(hsr.getParameter("inputPublisher"));
                    System.out.println(hsr.getParameter("inputCategory"));
                    System.out.println(hsr.getParameter("inputFormat"));
                    System.out.println(hsr.getParameter("inputDescription"));
                    System.out.println(hsr.getParameter("inputPrice"));
                    int isbn = Integer.parseInt(hsr.getParameter("inputIsbn"));
                    String title = hsr.getParameter("inputTitle");
                    String author = hsr.getParameter("inputAuthor");
                    String publisher = hsr.getParameter("inputPublisher");
                    String category = hsr.getParameter("inputCategory");
                    String format = hsr.getParameter("inputFormat");
                    String description = hsr.getParameter("inputDescription");
                    double price = Double.parseDouble(hsr.getParameter("inputPrice"));
                    book = new Book(isbn, title, author, publisher, category, format, description, price);
                    BookDAO.editBook(book);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            mv = new ModelAndView("userhomepage"); //the name of the .jsp view
            
            //If purchased book isbn is received, then remove it from cart
            if (hsr.getParameter("confirmBuyBook") != null) {
                int isbn = Integer.parseInt(hsr.getParameter("confirmBuyBook"));
                CartDAO.deleteBookFromCart(isbn, u);
            }
            
        }
        ///

        try {

            List<Book> list = BookDAO.listBooks();
            mv.addObject("books", list); //"users" syntax is used in users.jsp to list the usrs in the table

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(mv.getViewName());
        return mv;
    }

}
