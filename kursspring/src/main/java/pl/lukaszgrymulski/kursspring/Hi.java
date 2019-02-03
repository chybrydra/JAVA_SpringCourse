package pl.lukaszgrymulski.kursspring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Hi implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Bonjour le Monde!");
    }
}
