package pl.lukaszgrymulski.kursspring.domain;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;


public class Knight {

    private int id;

    @NotNull
    @Size(min=2, max=40, message="Imię rycerza musi mieć między 2-40 znaków")
    private String name;

    @NotNull
    @Range(min=18, max=60, message="Rycerz musi mieć pomiędzy 18 a 60 lat")
    private int age;

    private int level;

    private Quest quest;

    public Knight(){
        this.level=1;
    }

    public Knight(String name, int age) {
        this.name = name;
        this.age = age;
        this.level = 1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Quest getQuest() {
        return quest;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Knight knight = (Knight) o;
        return age == knight.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(age);
    }

    public void setQuest(Quest quest) {
        if (quest!=null){
            quest.setStarted(true);
        }
        this.quest = quest;
    }

    @Override
    public String toString() {
        return "Rycerz "+ name + ", lat " + age + ". Ma za zadanie: " + quest;
    }
}
