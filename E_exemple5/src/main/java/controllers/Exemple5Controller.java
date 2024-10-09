package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import services.Facade;

@Controller
@RequestMapping("/")
public class Exemple5Controller {
    @Autowired
    Facade facade;

    @GetMapping("/")
    public String hello(Model model) {
        model.addAttribute("listecomposites",facade.findAllComposites());
        model.addAttribute("listecomposants",facade.findAllComposants());
        return "hello";
    }

    @PostMapping("deletecomposite")
    public String deleteComposite(@RequestParam("idComposite") int idComposite, Model model) {
        facade.deleteComposite(idComposite);
        return hello(model);
    }

    @PostMapping("dereferencecomposant")
     public String dereferenceComposant(@RequestParam("idComposant") int idComposant, Model model) {
        facade.dereferenceComposant(idComposant);
        return hello(model);
    }

    @PostMapping("ajoutcomposant")
    public String ajoutComposant(@RequestParam("nomComposant") String nomComposant, @RequestParam("idComposite") int idComposite, Model model) {
        facade.createComposant(nomComposant,idComposite,false);
        return hello(model);
    }
}
