package ua.artcode.library.conroller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.artcode.library.model.Author;
import ua.artcode.library.service.AuthorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;

@WebServlet(urlPatterns = {"/author/add"})
public class SaveAuthorServlet extends BaseServlet {

    public static final String ADD_AUTHOR_JSP = "/WEB-INF/pages/author-add.jsp";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String salary = req.getParameter("salary");
        String birthday= req.getParameter("birthday");

        // validation

        // parse date
        Author author = new Author(name, Double.parseDouble(salary), new Date());

        service.addAuthor(author);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // some checking
        req.getRequestDispatcher(ADD_AUTHOR_JSP).forward(req,resp);
    }
}
