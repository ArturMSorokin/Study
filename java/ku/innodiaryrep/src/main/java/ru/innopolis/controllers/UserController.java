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

import java.sql.SQLException;

@Controller
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/private")
    public String privateZone(){
        return "private/private";
    }

    @RequestMapping(value = "/registration_form")
    public String registrationForm(){
        return "registration";
    }

    @RequestMapping (value = "/registration_process", method = RequestMethod.POST)
    public String registerUser(@RequestParam (value = "login") String login,
                               @RequestParam (value = "password") String password,
                               @RequestParam (value = "confirmedPassword") String confirmedPassword,
                               @RequestParam (value = "email") String email,
                               Model model){

        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        user.setEmail(email);

        try {
            String errors = userService.registerUser(user, confirmedPassword);

            if (errors.isEmpty()){
                model.addAttribute("RegSuccess", "Регистрация прошла успешно! Теперь вы можете войти в систему.");
                return "login";
            } else {
                model.addAttribute("RegError", errors);
                return "registration";
            }
        } catch (SQLException e) {
            logger.error("", e);
            return "sql_error";
        }
    }
}
