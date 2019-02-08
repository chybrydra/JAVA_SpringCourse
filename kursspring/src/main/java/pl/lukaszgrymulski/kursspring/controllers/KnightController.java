package pl.lukaszgrymulski.kursspring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.lukaszgrymulski.kursspring.domain.Knight;
import pl.lukaszgrymulski.kursspring.services.KnightService;

import java.util.List;

@Controller
public class KnightController {

    @Autowired
    KnightService service;

    @RequestMapping("/knights")
    public String getKnights(Model model){
        List<Knight> allKnights = service.getAllKnights();
        model.addAttribute("knights", allKnights);
        return "knights";
    }

    @RequestMapping("/knight")
    public String getKnight(@RequestParam("id") Integer id, Model model){
        Knight knight = service.getKnight(id);
        model.addAttribute("knight", knight);
        return "knight";
    }

    @RequestMapping("/newknight")
    public String createKnight(Model model){
        model.addAttribute("knight", new Knight());
        return "knightform";
    }

    @RequestMapping(value="/knights", method=RequestMethod.POST)
    public String saveKnight(Knight knight){
        service.saveKnight(knight);
        return "redirect:/knights";
    }

}
