package pl.lukaszgrymulski.kursspring.domain.repositories;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import pl.lukaszgrymulski.kursspring.domain.Knight;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class KnightRepository {

    Map<String, Knight> knights = new HashMap<>();

    public KnightRepository() { }

    public void createKnight(String name, int age){
        knights.put(name, new Knight(name, age));
    }

    public Collection<Knight> getAllKnights(){
        return knights.values();
    }

    public Knight getKnight(String name){
        return knights.get(name);
    }

    public void deleteKnight(String name){
        knights.remove(name);
    }

    @PostConstruct
    public void build(){
        createKnight("Lancelot", 29);
        createKnight("Percival", 25);
    }

    @Override
    public String toString() {
        return "KnightRepository{" +
                "knights=" + knights +
                '}';
    }
}
