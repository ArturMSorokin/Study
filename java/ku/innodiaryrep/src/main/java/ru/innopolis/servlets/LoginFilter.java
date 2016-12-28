package ru.innopolis.servlets;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Класс перехватывает неавторизованных пользователей и направляет их на страницу входа.
 */
@WebFilter (urlPatterns = "/private")
public class LoginFilter implements Filter {

    private ServletContext context;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.context = filterConfig.getServletContext();
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);

        boolean loggedIn = session != null && session.getAttribute("username") != null;
        boolean loginRequest = req.getRequestURI().equals(req.getContextPath() + "/login");

        if (loggedIn) {
            chain.doFilter(req, res);
        } else if (loginRequest){
            context.getRequestDispatcher(req.getContextPath() + "/login_process").forward(req, res);
        } else {
            res.sendRedirect(req.getContextPath() + "/login_page");
        }
    }

    @Override
    public void destroy() {

    }

}