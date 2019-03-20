package pl.lukaszgrymulski.kursspring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import pl.lukaszgrymulski.kursspring.domain.repositories.DBKnightRepository;
import pl.lukaszgrymulski.kursspring.domain.repositories.InMemoryRepository;
import pl.lukaszgrymulski.kursspring.domain.repositories.KnightRepository;


@Configuration
public class MainConfig {

    @Bean(name="InMemoryKnightRepository")
    @Profile("dev")
    public KnightRepository createInMemoryRepo(){
        KnightRepository repo = new InMemoryRepository();
        return repo;
    }

    @Bean(name="DBKnightRepository")
    @Profile("prod")
    public KnightRepository createDBRepo(){
        KnightRepository repo = new DBKnightRepository();
        return repo;
    }
}
