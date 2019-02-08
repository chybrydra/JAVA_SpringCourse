package pl.lukaszgrymulski.kursspring.domain;

import java.util.Objects;


public class Knight {

    private int id;
    private String name;
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
        System.out.println("Przydzielam zadanie rycerzowi.");
        this.quest = quest;
    }

    @Override
    public String toString() {
        return "Rycerz "+ name + ", lat " + age + ". Ma za zadanie: " + quest;
    }
}
