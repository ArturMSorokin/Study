package ru.innopolis.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.innopolis.pojo.User;
import ru.innopolis.service.UserService;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

@Controller
public class RootController {

    private static Logger logger = LoggerFactory.getLogger(RootController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private UserController userController;

    @RequestMapping(value = "/")
    public String homePage(){
        return "index";
    }

    @RequestMapping(value = "/index")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/login_page")
    public String loginPage(){
        return "login";
    }

    @RequestMapping(value = "/login_process", method = RequestMethod.POST)
    public String loginProcess(@RequestParam(value = "username") String username,
                               @RequestParam (value = "password") String password,
                               HttpSession session,
                               Model model){

        User user = new User();
        user.setLogin(username);
        user.setPassword(password);

        try {
            if (userService.userIsRegistered(user)){

                session.setAttribute("username", username);
                session.setMaxInactiveInterval(30*60);
                return userController.privateZone();

            } else {
                model.addAttribute("Error", "Пожалуйста, введите действительные имя пользователя и пароль.");
                return "login";
            }
        } catch (SQLException e) {
            logger.error("", e);
            return "sql_error";
        }
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpServletResponse resp, HttpSession session){
        resp.setHeader("Cache-Control", "no-cache, no-store");
        resp.setHeader("Pragma", "no-cache");
        session.invalidate();
        return ("index");
    }

}
