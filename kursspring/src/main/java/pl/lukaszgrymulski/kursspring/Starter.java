package pl.lukaszgrymulski.kursspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pl.lukaszgrymulski.kursspring.domain.repositories.KnightRepository;
import pl.lukaszgrymulski.kursspring.domain.repositories.QuestRepository;
import pl.lukaszgrymulski.kursspring.services.QuestService;

@Component
@Scope("singleton")
public class Starter implements CommandLineRunner {

    @Autowired
    KnightRepository knightRepository;

    @Autowired
    QuestRepository questRepository;

    @Autowired
    QuestService questService;

    @Override
    public void run(String... args) throws Exception {
        questRepository.createRandomQuest();
        questRepository.createRandomQuest();
        questService.assignRandomQuest("Percival");
    }
}
