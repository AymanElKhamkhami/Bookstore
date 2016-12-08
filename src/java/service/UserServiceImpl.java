/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import model.pojo.User;
import model.util.HibernateUtil;
import org.hibernate.SessionFactory;

/**
 *
 * @author Ayman
 */
public class UserServiceImpl implements UserService {

    private SessionFactory sessionFactory;
    
    @Override
    public void add(User user) {
        //Persist the user object here.       
        try {
            System.out.println(user.getName()+" "+user.getLogin());
            user = new User("default", "default", "default", "default", "default", "m"/*,"default"*/);
            sessionFactory.openSession().saveOrUpdate(user);
	
            
            System.out.println("User added successfully");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }      
        
        
    }

}
