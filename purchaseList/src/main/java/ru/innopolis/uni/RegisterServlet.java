package ru.innopolis.uni;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by olymp on 18.11.2016.
 */
public class RegisterServlet extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(RegisterServlet.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("doGet????");
        getServletContext().getRequestDispatcher("/registration.jsp").forward(req,resp);
    }
}
