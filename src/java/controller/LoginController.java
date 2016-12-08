/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dto.LoginForm;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.dao.UserDAO;
import model.pojo.User;
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
public class LoginController extends SimpleFormController {

    private UserService userService;

    public LoginController() {
        setCommandClass(LoginForm.class);
        setCommandName("loginForm");
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {

        LoginForm form = (LoginForm) command;

        try {
            List<User> list = UserDAO.listUsers();
            for (User u : list) {
                if ((u.getEmail().equals(form.getEmailOrLogin()) || u.getLogin().equals(form.getEmailOrLogin())) && u.getPassword().equals(form.getPassword())) {
                    HttpSession session = request.getSession();
                    session.setAttribute("sessionuser", u);

                    if (u.getLogin().equals("admin")) {
                        return new ModelAndView(new RedirectView("adminhomepage.htm"));
                    } else {
                        return new ModelAndView(new RedirectView("userhomepage.htm"));
                    }
                }
            }

            return new ModelAndView(new RedirectView("login.htm?loginerror=true"));

        } catch (Exception e) {
            e.printStackTrace();
            return new ModelAndView(new RedirectView("loginerror.htm"));
        }

    }

}
