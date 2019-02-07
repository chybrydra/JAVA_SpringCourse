package pl.lukaszgrymulski.kursspring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.lukaszgrymulski.kursspring.domain.Knight;
import pl.lukaszgrymulski.kursspring.domain.Quest;
import pl.lukaszgrymulski.kursspring.domain.repositories.KnightRepository;
import pl.lukaszgrymulski.kursspring.domain.repositories.QuestRepository;

import java.util.List;
import java.util.Random;

@Service
public class QuestService {

    @Autowired
    KnightRepository knightRepository;

    @Autowired
    QuestRepository questRepository;

    final static Random rand = new Random();

    public void assignRandomQuest(String knightName){
        List<Quest> allQuests = questRepository.getAll();
        Quest randomQuest = allQuests.get(rand.nextInt(allQuests.size()));
        knightRepository.getKnight(knightName).setQuest(randomQuest);
        questRepository.deleteQuest(randomQuest);
    }
}
