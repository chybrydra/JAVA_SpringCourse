package pl.lukaszgrymulski.kursspring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.lukaszgrymulski.kursspring.domain.Castle;
import pl.lukaszgrymulski.kursspring.domain.Knight;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KursspringApplicationTests {

	@Autowired
	Knight knight;

	@Autowired
	Castle castle;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testCastle(){
		String expected = "Znajduje się tu zamek o nazwie East Watch. Zamieszkuje go rycerz Rycerz Lancelot, lat 29. Ma za zadanie: Uratować księżniczkę.";
		assertEquals(expected, castle.toString());
	}

}

