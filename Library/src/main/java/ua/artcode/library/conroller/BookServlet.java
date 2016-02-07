package ua.artcode.library.conroller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.test.annotation.Commit;
import ua.artcode.library.exception.NoBookFoundException;
import ua.artcode.library.model.Book;
import ua.artcode.library.service.AuthorService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Date;

/**
 * localhost/book?bookId=34
 */
public class BookServlet extends BaseServlet {

    public static final String APP_NAME = "library";
    public static final String ERROR_PAGE = "/pages/general-error.html";
    public static final String BOOK_INFO_JSP = "/WEB-INF/pages/book-info.jsp";


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String query = req.getQueryString();// url /book
        String bookId = req.getParameter("bookId");

        if(bookId == null){
            resp.sendRedirect("/" + APP_NAME + ERROR_PAGE);
        }

        Book book = null;
        try {
            book = service.getBookById(Integer.parseInt(bookId));
            req.setAttribute("book", book);
            req.getRequestDispatcher(BOOK_INFO_JSP).forward(req, resp);
        } catch (NoBookFoundException e) {
            resp.sendRedirect("/" + APP_NAME + ERROR_PAGE);
            /*req.setAttribute("errMessage", e);
            req.getRequestDispatcher(ERROR_JSP).forward(req,resp);*/
        }


        // getServletContext().setAttribute("factory", "factory");
        //req.getSession().setAttribute();


    }
}
