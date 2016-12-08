/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.UserDAO;
import model.pojo.User;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author Ayman
 */
public class ListController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView mv = new ModelAndView("users"); //the name of the .jsp view
        
        try{
            List<User> list = UserDAO.listUsers();
            mv.addObject("users", list); //"users" syntax is used in users.jsp to list the usrs in the table
        } catch(Exception e){
            e.printStackTrace();
        }
        
        return mv;
    }
    
}
