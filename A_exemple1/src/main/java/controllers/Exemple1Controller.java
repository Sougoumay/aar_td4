package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import services.Facade;

@Controller
@RequestMapping("/")
public class Exemple1Controller {
    @Autowired
    Facade facade;

    @RequestMapping("")
    public String hello(Model model) {
        model.addAttribute("employes",facade.findAllEmploye());
        return("hello");
    }
}
