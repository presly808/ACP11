package ua.artcode.library.conroller;

import org.springframework.context.ApplicationContext;
import ua.artcode.library.service.AuthorService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class BaseServlet extends HttpServlet {

    protected AuthorService service;

    @Override
    public void init() throws ServletException {
        ApplicationContext springContext = (ApplicationContext) getServletContext().getAttribute("springContext");
        service = springContext.getBean(AuthorService.class);
    }
}
