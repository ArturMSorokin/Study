package ru.innopolis.uni;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by olymp on 18.11.2016.
 */
public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletConfig().getRequestDispathcher
        OutputStream os = resp.getOutputStream();
        os.write("<html><body>Hello, world!</body></html>".getBytes());
    }
}