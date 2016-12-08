/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dto.AddBookForm;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.BookDAO;
import model.pojo.Book;
import model.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
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
public class AddBookController extends SimpleFormController implements ResourceLoaderAware {

    private UserService userService;
    private ResourceLoader resourceLoader;

    public AddBookController() {
        setCommandClass(AddBookForm.class);
        setCommandName("addBookForm");
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {

        AddBookForm form = (AddBookForm) command;
        Book book = form.getBook();

        //userService.add(user);
        try {
            List<Book> list = BookDAO.listBooks();
            for (Book b : list) {
                if (b.getIsbn() == book.getIsbn()) {
                    return new ModelAndView(new RedirectView("duplicateerror.htm"));
                }
            }

            //Resource resource = resourceLoader.getResource("classpath:" + book.getIsbn() + ".jpg");
            //String output = request.getServletContext().getRealPath("/images/"+book.getIsbn()+".jpg");
            //form.getImage().transferTo(new File(output));
            //form.getImage().transferTo(resource.getFile());
            String path = request.getRealPath("/images");
            path = path.substring(0, path.indexOf("\\build"));
            path += "\\web\\images\\"+book.getIsbn()+".jpg";
            form.getImage().transferTo(new File(path));

            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.saveOrUpdate(book);
            session.getTransaction().commit();

            return new ModelAndView("addsuccess", "book", book);

        } catch (IOException | IllegalStateException | HibernateException e) {
            e.printStackTrace();
            return new ModelAndView(new RedirectView("adderror.htm"));
        }

    }

    @Override
    public void setResourceLoader(ResourceLoader rl) {
        this.resourceLoader = rl;
    }

    public Resource getResource(String location) {
        return resourceLoader.getResource(location);
    }

}
