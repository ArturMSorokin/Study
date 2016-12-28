package ru.innopolis.uni.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by olymp on 10.12.2016.
 */
@Controller
@RequestMapping("/")
public class StudentController {
    @RequestMapping(name="/login",method = RequestMethod.GET)
    public String login(Model model) {
        String username = "someDummyName";
        model.addAttribute("username", username);
        return "login";
    }
}
