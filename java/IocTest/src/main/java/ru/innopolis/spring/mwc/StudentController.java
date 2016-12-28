package ru.innopolis.spring.mwc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by olymp on 25.11.2016.
 */
@Controller
public class StudentController {
    @RequestMapping("/hello")
    public String getStudentList(Model model) {
        model.addAttribute("message","hello");
        return "stdList";
    }
}
