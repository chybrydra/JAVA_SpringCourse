package pl.lukaszgrymulski.kursspring.domain;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;


public class Knight {
    private String name;
    private int age;
    private Quest quest;

    public Knight(){
        this.name = "Lancelot";
        this.age = 29;
    }

    public Knight(String name, int age) {
        this.name = name;
        this.age = age;
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

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Rycerz "+ name + ", lat " + age + ". Ma za zadanie: " + quest;
    }
}
