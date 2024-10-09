package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import services.Facade;

@Controller
@RequestMapping("/")
public class Exemple4Controller {
    @Autowired
    Facade facade;

    @RequestMapping("")
    public String hello(Model model) {
        model.addAttribute("employes",facade.findAllEmploye());
        model.addAttribute("nonAffectes",facade.nonAffectes());
        model.addAttribute("mac",facade.findMachineById(1));
        model.addAttribute("paysdemac",facade.PaysDuProprietaireDe(1));
        model.addAttribute("personnage",facade.findEmployeById(5));
        model.addAttribute("acolytes",facade.travailleAvec(5));
        model.addAttribute("codeProjet","EGOUTS");
        model.addAttribute("projetACode",facade.nomDuProjet("EGOUTS"));
        model.addAttribute("sansProjetNatif",facade.sansProjetNatif());
        model.addAttribute("sansProjetDto",facade.sansProjetDto());
        return("hello");
    }
}
