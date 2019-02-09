package pl.lukaszgrymulski.kursspring.domain.repositories;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;
import pl.lukaszgrymulski.kursspring.domain.Quest;
import pl.lukaszgrymulski.kursspring.utils.Ids;

import javax.annotation.PostConstruct;
import java.util.*;

@Repository
public class QuestRepository {

    Map<Integer, Quest> quests = new HashMap<>();

    Random rand = new Random();

    public void createQuest(String description){
        int newId = Ids.getNewId(quests.keySet());
        Quest newQuest = new Quest(newId, description);
        quests.put(newId, newQuest);
    }

    public List<Quest> getAll(){
        return new ArrayList<>(quests.values());
    }

    public void deleteQuest(Quest quest){
        quests.remove(quest.getId());
    }

    @PostConstruct
    public void init(){
    }

    @Override
    public String toString() {
        return "QuestRepository{" +
                "quests=" + quests +
                '}';
    }

    @Scheduled(fixedDelayString = "${questCreationDelay}")
    public void createRandomQuest(){
        List<String> descriptions = new ArrayList<>();
        descriptions.add("Uratuj księżniczkę");
        descriptions.add("Weź udział w turnieju");
        descriptions.add("Zabij bandę goblinów");
        descriptions.add("Zabij smoka");
        String description = descriptions.get(rand.nextInt(descriptions.size()));
        createQuest(description);
    }

    public void update(Quest quest) {
        quests.put(quest.getId(), quest);
    }

    public Quest getQuest(Integer id) {
        return quests.get(id);
    }
}
