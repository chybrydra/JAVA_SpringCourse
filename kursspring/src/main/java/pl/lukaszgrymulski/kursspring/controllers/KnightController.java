package pl.lukaszgrymulski.kursspring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.lukaszgrymulski.kursspring.components.TimeComponent;
import pl.lukaszgrymulski.kursspring.domain.Knight;
import pl.lukaszgrymulski.kursspring.domain.PlayerInformation;
import pl.lukaszgrymulski.kursspring.services.KnightService;

import java.util.List;

@Controller
public class KnightController {

    @Autowired
    PlayerInformation playerInformation;

    @Autowired
    TimeComponent timeComponent;

    @Autowired
    KnightService service;

    @RequestMapping("/knights")
    public String getKnights(Model model){
        List<Knight> allKnights = service.getAllKnights();
        model.addAttribute("knights", allKnights);
        model.addAttribute("timecomponent", timeComponent);
        model.addAttribute("playerinformation", playerInformation);
        return "knights";
    }

    @RequestMapping("/knight")
    public String getKnight(@RequestParam("id") Integer id, Model model){
        Knight knight = service.getKnight(id);
        model.addAttribute("knight", knight);
        model.addAttribute("timecomponent", timeComponent);
        model.addAttribute("playerinformation", playerInformation);
        return "knight";
    }

    @RequestMapping("/newknight")
    public String createKnight(Model model){
        model.addAttribute("knight", new Knight());
        model.addAttribute("timecomponent", timeComponent);
        model.addAttribute("playerinformation", playerInformation);
        return "knightform";
    }

    @RequestMapping(value="/knights", method=RequestMethod.POST)
    public String saveKnight(Knight knight){
        service.saveKnight(knight);
        return "redirect:/knights";
    }

    @RequestMapping(value="/knight/delete/{id}")
    public String deleteKnight(@PathVariable("id") Integer id){
        service.deleteKnight(id);
        return "redirect:/knights";
    }

}
