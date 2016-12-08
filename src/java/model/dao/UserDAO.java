/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.dao;

import java.util.List;
import model.pojo.User;
import model.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Ayman
 */
public class UserDAO {
    
    public static List<User> listUsers(){
        List<User> list = null;
        
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from User");
            list = query.list();
            session.close();
        } catch(HibernateException e){
            e.printStackTrace();
        }
        
        return list;
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
