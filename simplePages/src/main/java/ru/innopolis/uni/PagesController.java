package ru.innopolis.uni;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by olymp on 05.12.2016.
 */
@Controller
public class PagesController {
    @GetMapping(value = "/only_for_users")
    public String forUsers(Model model) {
        return "onlyForUsers";
    }
    @GetMapping(value="/only_for_admin")
    public String forAdmin(Model model) {
        return "onlyForAdmin";
    }

}
