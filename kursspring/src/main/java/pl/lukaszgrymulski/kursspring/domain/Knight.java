package pl.lukaszgrymulski.kursspring.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Knight {
    private String name = "Lancelot";
    private int age = 29;
    private Quest quest;

    public Knight(){

    }

    public Knight(String name, int age, Quest quest) {
        this.name = name;
        this.age = age;
        this.quest = quest;
    }

    @Autowired
    public void setQuest(Quest quest) {
        System.out.println("Łap zadanie rycerzu!");
        this.quest = quest;
    }

    @Override
    public String toString() {
        return "Rycerz "+ name + ", lat " + age + ". Ma za zadanie: " + quest;
    }
}
