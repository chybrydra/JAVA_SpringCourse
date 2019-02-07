package pl.lukaszgrymulski.kursspring.domain.repositories;

import org.springframework.stereotype.Repository;
import pl.lukaszgrymulski.kursspring.domain.Quest;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class QuestRepository {

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
        createQuest("Uratuj księżniczkę");
        createQuest("Weź udział w turnieju");
    }

    @Override
    public String toString() {
        return "QuestRepository{" +
                "questList=" + questList +
                '}';
    }
}
