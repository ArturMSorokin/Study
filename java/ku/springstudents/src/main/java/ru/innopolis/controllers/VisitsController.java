package ru.innopolis.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VisitsController {

    @RequestMapping("/add_visit")
    public String addVisitForm(){
        return "add_visit_form";
    }
}
