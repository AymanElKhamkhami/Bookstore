/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.pojo.Book;
import model.pojo.Cart;
import model.pojo.Cartbook;
import model.pojo.User;
import model.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Ayman
 */
public class CartDAO {

    public static void addBookToCart(User user, int bookIsbn, int quantity, Date date) {
        List<Cart> carts;
        List<Book> books;
        List<Cartbook> cbs;
        Cart cart = null;
        Book book = null;
        Cartbook cartbook = null;

        try {

            //find the cart of the specified user
            Session session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Cart");
            carts = query.list();

            for (Cart c : carts) {
                if (c.getUser().getId() == user.getId()) {
                    cart = c;
                }
            }
            ///

            //find the book with specified isbn
            query = session.createQuery("from Book");
            books = query.list();

            for (Book b : books) {
                if (b.getIsbn() == bookIsbn) {
                    book = b;
                }
            }
            ////

            //cartbook = new Cartbook(cart, book, quantity, date, "a");
            //Test if the book already exists in the cart
            query = session.createQuery("from Cartbook");
            cbs = query.list();

            for (Cartbook cb : cbs) {
                //if the book add already exist in the cart, just increment the quantity
                if ((cb.getBook().getIsbn() == book.getIsbn()) && (cb.getCart().getIdCart() == cart.getIdCart())) {
                    cartbook = cb;
                    cartbook.setQuantity(cartbook.getQuantity() + quantity);
                    break;
                }
                cartbook = new Cartbook(cart, book, quantity, date, "a");
            }

            session.beginTransaction();
            session.saveOrUpdate(cartbook);
            session.getTransaction().commit();
            //session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    public static List<Book> listBooksInCart(User user) {
        List<Book> books = new ArrayList<>();
        List<Cart> carts;
        List<Cartbook> cbs;
        Cart cart = null;

        //find the cart of the specified user
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from Cart");
        carts = query.list();

        for (Cart c : carts) {
            if (c.getUser().getId() == user.getId()) {
                cart = c;
            }
        }
        ///

        //find the books in the specified cart in the cartbook relation table
        query = session.createQuery("from Cartbook");
        cbs = query.list();

        for (Cartbook cb : cbs) {
            if (cb.getCart().getIdCart() == cart.getIdCart()) {
                books.add(cb.getBook());
            }
        }
        ///
        //session.close();

        return books;
    }

    public static void deleteBookFromCart(int bookIsbn, User user) {
        List<Cart> carts;
        List<Cartbook> cbs;
        Cart cart = null;

        //find the cart of the specified user
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from Cart");
        carts = query.list();

        for (Cart c : carts) {
            if (c.getUser().getId() == user.getId()) {
                cart = c;
            }
        }
        ///

        //find the book with specified isbn in the cartbook relation table
        query = session.createQuery("from Cartbook");
        cbs = query.list();

        for (Cartbook cb : cbs) {
            if ((cb.getBook().getIsbn() == bookIsbn) && (cb.getCart().getIdCart() == cart.getIdCart())) {
                session.beginTransaction();
                session.delete(cb);
                session.getTransaction().commit();
                //session.close();
                session.flush();
            }
        }
        ////
    }

}
