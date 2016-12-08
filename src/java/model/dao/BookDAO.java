/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import model.pojo.Book;
import model.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Ayman
 */
public class BookDAO {

    public static List<Book> listBooks() {
        List<Book> list = null;

        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Book");
            list = query.list();
            session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
        }

        return list;
    }
    

    public static void deleteBook(Book book) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(book);
            session.getTransaction().commit();
            session.close();
            session.flush();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
    
    public static void editBook(Book book) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.saveOrUpdate(book);
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    /*
     public static void registerUser(User user){
     try {
     HibernateUtil.getSessionFactory().getCurrentSession().saveOrUpdate(user);
	
     System.out.println("User added successfully");
     } catch (Exception e) {
     System.out.println(e.getMessage());
     }      
     }*/
}
