package pl.lukaszgrymulski.kursspring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.lukaszgrymulski.kursspring.domain.Knight;
import pl.lukaszgrymulski.kursspring.domain.PlayerInformation;
import pl.lukaszgrymulski.kursspring.domain.repositories.KnightRepository;
import pl.lukaszgrymulski.kursspring.domain.repositories.PlayerInformationRepository;
import pl.lukaszgrymulski.kursspring.domain.repositories.QuestRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class KnightService {

    @Autowired
    QuestRepository questRepository;

    @Autowired
    KnightRepository repository;

    @Autowired
    PlayerInformationRepository playerInformationRepository;


    public List<Knight> getAllKnights(){
        return new ArrayList<>(repository.getAllKnights());
    }

    public void saveKnight(Knight knight) {
        repository.createKnight(knight);
    }

    public Knight getKnight(Integer id) {
        return repository.getKnightById(id);
    }

    public void deleteKnight(Integer id) {
        repository.deleteKnight(id);
    }

    public void updateKnight(Knight knight) {
        repository.updateKnight(knight.getId(), knight);
    }

    public int collectRewards() {

        Predicate<Knight> knightPredicate = knight -> {
            if (knight.getQuest() != null) {
                return knight.getQuest().isCompleted();
            } else {
                return false;
            }
        };

        int sum = repository.getAllKnights().stream()
                .filter(knightPredicate)
                .mapToInt(knight -> knight.getQuest().getReward())
                .sum();

        repository.getAllKnights().stream()
                .filter(knightPredicate)
                .forEach(knight -> knight.setQuest(null));

        return sum;
    }

    @Transactional
    public void getMyGold(){
        List<Knight> allKnights = getAllKnights();
        allKnights.forEach(knight -> {
            if (knight.getQuest() != null) {
                boolean completed = knight.getQuest().isCompleted();
                if(completed) {
                    questRepository.update(knight.getQuest());
                }
            }
        });
        PlayerInformation first = playerInformationRepository.getFirst();
        int currentGold = first.getGold();
        first.setGold(currentGold + collectRewards());
    }
}
