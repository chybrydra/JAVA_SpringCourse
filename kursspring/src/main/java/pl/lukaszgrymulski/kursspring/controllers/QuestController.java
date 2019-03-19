package pl.lukaszgrymulski.kursspring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.lukaszgrymulski.kursspring.domain.Knight;
import pl.lukaszgrymulski.kursspring.domain.PlayerInformation;
import pl.lukaszgrymulski.kursspring.domain.Quest;
import pl.lukaszgrymulski.kursspring.domain.repositories.PlayerInformationRepository;
import pl.lukaszgrymulski.kursspring.services.KnightService;
import pl.lukaszgrymulski.kursspring.services.QuestService;

import java.util.List;

@Controller
public class QuestController {

    @Autowired
    KnightService knightService;

    @Autowired
    QuestService questService;

    @Autowired
    PlayerInformationRepository playerInformationRepository;

    @RequestMapping("/assignQuest")
    public String assignQuest(@RequestParam("knightId") Integer id, Model model){
        Knight knight = knightService.getKnight(id);
        List<Quest> notStartedQuests = questService.getAllNotStartedQuests();
        model.addAttribute("knight", knight);
        model.addAttribute("notStartedQuests", notStartedQuests);
        return "assignQuest";
    }

    @RequestMapping(value="/assignQuest", method= RequestMethod.POST)
    public String assignQuest(Knight knight){
        knightService.updateKnight(knight);
        Quest quest = knight.getQuest();
        questService.update(quest);
        return "redirect:/knights";
    }

    @RequestMapping(value="/checkQuests")
    public String checkQuests(){
        knightService.getMyGold();
        return "redirect:/knights";
    }

}
