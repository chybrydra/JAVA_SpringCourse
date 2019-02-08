package pl.lukaszgrymulski.kursspring.domain.repositories;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;
import pl.lukaszgrymulski.kursspring.domain.Quest;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class QuestRepository {

    Random rand = new Random();

    List<Quest> questList = new ArrayList<>();

    public void createQuest(String description){
        questList.add(new Quest(description));
    }

    public List<Quest> getAll(){
        return questList;
    }

    public void deleteQuest(Quest quest){
        questList.remove(quest);
    }

    @PostConstruct
    public void init(){
    }

    @Override
    public String toString() {
        return "QuestRepository{" +
                "questList=" + questList +
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
        System.out.println("Utworzyłem zadanie o opisie: " + description);
        createQuest(description);
    }
}
