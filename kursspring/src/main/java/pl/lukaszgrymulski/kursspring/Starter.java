package pl.lukaszgrymulski.kursspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pl.lukaszgrymulski.kursspring.domain.PlayerInformation;
import pl.lukaszgrymulski.kursspring.domain.repositories.KnightRepository;
import pl.lukaszgrymulski.kursspring.domain.repositories.PlayerInformationRepository;
import pl.lukaszgrymulski.kursspring.domain.repositories.QuestRepository;
import pl.lukaszgrymulski.kursspring.services.QuestService;

import javax.transaction.Transactional;

@Component
@Scope("singleton")
public class Starter implements CommandLineRunner {

    @Autowired
    KnightRepository knightRepository;

    @Autowired
    QuestRepository questRepository;

    @Autowired
    QuestService questService;

    @Autowired
    PlayerInformationRepository playerInformationRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        questRepository.createRandomQuest();
        questRepository.createRandomQuest();
        knightRepository.createKnight("Percival", 32);
        playerInformationRepository.createPlayerInformation(new PlayerInformation());
        questService.assignRandomQuest("Percival");
    }
}
