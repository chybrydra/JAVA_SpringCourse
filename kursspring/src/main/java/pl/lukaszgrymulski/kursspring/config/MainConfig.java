package pl.lukaszgrymulski.kursspring.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import pl.lukaszgrymulski.kursspring.domain.repositories.DBKnightRepository;
import pl.lukaszgrymulski.kursspring.domain.repositories.InMemoryRepository;
import pl.lukaszgrymulski.kursspring.domain.repositories.KnightRepository;


@Configuration
public class MainConfig extends WebSecurityConfigurerAdapter {

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

    @Autowired
    public void securityUsers(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin").password("{noop}admin").roles("ADMIN")
                .and()
                .withUser("anna").password("{noop}aaa").roles("USER");
    }

}
