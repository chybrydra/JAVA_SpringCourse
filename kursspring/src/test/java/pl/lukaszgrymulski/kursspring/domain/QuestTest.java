package pl.lukaszgrymulski.kursspring.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class QuestTest {

    @Test
    public void settingStartedFlagToFalseShouldSetStartDate(){
        Quest quest = new Quest("Testowe zadanie");
        quest.setStarted(true);
        assertNotNull(quest.startDate);
    }

    @Test
    public void questShouldBeCompleted(){
        Quest quest = new Quest("Testowe zadanie");
        quest.setStarted(true);
        quest.lengthInSeconds = -60;
        assertTrue(quest.isCompleted());
        assertTrue(quest.isCompleted());
    }

    @Test
    public void questShouldNotBeCompleted(){
        Quest quest = new Quest("Testowe zadanie");
        quest.setStarted(true);
        quest.lengthInSeconds = 20000;
        assertFalse(quest.isCompleted());
        assertFalse(quest.isCompleted());
    }
}
