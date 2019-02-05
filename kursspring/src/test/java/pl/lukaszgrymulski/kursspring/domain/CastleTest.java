package pl.lukaszgrymulski.kursspring.domain;

import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class CastleTest {

    @Test
    public void castleToStringMessage(){
        Quest quest = new Quest();
        Knight knight = new Knight();
        knight.setQuest(quest);
        Castle castle = new Castle(knight, "East Watch");
        String expected = "Znajduje się tu zamek o nazwie East Watch. Zamieszkuje go rycerz Rycerz Lancelot, lat 29. Ma za zadanie: Uratować księżniczkę.";
        assertEquals(expected, castle.toString());
    }
}
