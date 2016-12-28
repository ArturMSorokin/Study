package ru.innopolis.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RootController {

    @RequestMapping(value = "/")
    public String homePage(){
        return "index";
    }

    @RequestMapping(value = "/index")
    public String index(){
        return "index";
    }
}
