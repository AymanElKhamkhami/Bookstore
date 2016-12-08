/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dto.RegistrationForm;
import java.util.List;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import model.dao.UserDAO;
import model.pojo.Cart;
import model.pojo.User;
import model.util.HibernateUtil;
import org.hibernate.Session;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;
import service.UserService;

/**
 *
 * @author Ayman
 */
@SuppressWarnings("deprecation")
public class RegistrationController extends SimpleFormController {

    private UserService userService;

    public RegistrationController() {
        setCommandClass(RegistrationForm.class);
        setCommandName("registrationForm");
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected ModelAndView onSubmit(Object command) throws Exception {

        //User user = (User) command;
        RegistrationForm form = (RegistrationForm) command;
        User user = form.getUser();
        Cart cart = new Cart(user);
        //userService.add(user);
        try {
            List<User> list = UserDAO.listUsers();
            for (User u : list) {
                if (u.getLogin().equals(user.getLogin()) || u.getEmail().equals(user.getEmail())) {
                    return new ModelAndView(new RedirectView("register.htm?duplicate=true"));
                }
            }

            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(user);
            session.save(cart);
            session.getTransaction().commit();
            //Send an email to the new user
            String host = "smtp-mail.outlook.com";
            final String from = "ayman.khm@gmail.com";
            final String pass = "openformeopenforme";
            String to = user.getEmail();
            
            Properties properties = new Properties();
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.starttls.enable", "true");
            properties.put("mail.smtp.host", "smtp.gmail.com");
            properties.put("mail.smtp.port", "587");
            
            javax.mail.Session s = javax.mail.Session.getInstance(properties, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(from, pass);
                }
            });
            
            try {
                // Create a default MimeMessage object.
                MimeMessage message = new MimeMessage(s);
                // Set From: header field of the header.
                message.setFrom(new InternetAddress(from));
                // Set To: header field of the header.
                message.setRecipients(Message.RecipientType.TO,
                        InternetAddress.parse(to));
                // Set Subject: header field
                message.setSubject("Spring App Online Store");
                // Now set the actual message
                message.setText("Registration complete\n"
                        + "Your username: " + user.getLogin() + "\n"
                        + "Thanks for joining us,\n"
                        + "Spring App Store Team.");
                // Send message
                Transport.send(message);
                System.out.println("Sent message successfully....");
            } catch (MessagingException mex) {
                mex.printStackTrace();
            }
            //
            return new ModelAndView("addsuccess", "user", user);

        } catch (Exception e) {
            e.printStackTrace();
            return new ModelAndView(new RedirectView("adderror.htm"));
        }

    }

}
