package pl.lukaszgrymulski.kursspring.domain;

import org.springframework.stereotype.Component;

@Component
public class Quest {

    private String description;

    public Quest() {
        description = "Uratować księżniczkę.";
    }

    @Override
    public String toString() {
        return description;
    }
}
