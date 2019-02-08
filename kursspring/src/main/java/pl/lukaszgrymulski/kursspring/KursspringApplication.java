package pl.lukaszgrymulski.kursspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class KursspringApplication {
	public static void main(String[] args) {
		SpringApplication.run(KursspringApplication.class, args);
	}

}

