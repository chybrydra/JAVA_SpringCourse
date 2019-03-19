package pl.lukaszgrymulski.kursspring.domain;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
public class PlayerInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int gold = 0;

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }
}
