package ru.innopolis.spring.Ioc;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by olymp on 24.11.2016.
 */
public class Servlet extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(Servlet.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("doGet????");
        getServletContext().getRequestDispatcher("/index.jsp").forward(req,resp);
//        OutputStream os = resp.getOutputStream();
//        os.write("<html><body>Hello, world!</body></html>".getBytes());
    }

}
