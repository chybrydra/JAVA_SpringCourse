package pl.lukaszgrymulski.kursspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.lukaszgrymulski.kursspring.domain.Castle;
import pl.lukaszgrymulski.kursspring.domain.Knight;
import pl.lukaszgrymulski.kursspring.domain.Quest;

@Component
public class Starter implements CommandLineRunner {

    @Autowired
    Castle castle;

    @Override
    public void run(String... args) throws Exception {

        System.out.println(castle);
    }
}
