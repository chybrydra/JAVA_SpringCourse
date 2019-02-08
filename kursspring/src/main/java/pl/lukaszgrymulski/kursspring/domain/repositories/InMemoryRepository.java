package pl.lukaszgrymulski.kursspring.domain.repositories;

import pl.lukaszgrymulski.kursspring.domain.Knight;

import javax.annotation.PostConstruct;
import java.util.*;


public class InMemoryRepository implements KnightRepository {

    Map<Integer, Knight> knights = new HashMap<>();

    public InMemoryRepository() { }

    @Override
    public void createKnight(String name, int age){
        Knight newKnight = new Knight(name, age);
        newKnight.setId(getNewId());
        knights.put(newKnight.getId(), newKnight);
    }

    private int getNewId() {
        if (knights.isEmpty()) {
            return 0;
        } else {
            Set<Integer> idSet = knights.keySet();
            Integer maxId=0;
            for (Integer id : idSet){
                maxId = id>maxId ? id : maxId;
            }
            return maxId+1;
        }
    }

    @Override
    public void createKnight(Knight knight) {
        knight.setId(getNewId());
        knights.put(knight.getId(), knight);
    }

    @Override
    public Knight getKnightById(Integer id) {
        return knights.get(id);
    }

    @Override
    public Collection<Knight> getAllKnights(){
        return knights.values();
    }

    @Override
    public Optional<Knight> getKnight(String name){
        Optional<Knight> knightByName = knights.values()
                .stream()
                .filter(knight -> knight.getName().equals(name))
                .findAny();
        return knightByName;
    }

    @Override
    public void deleteKnight(Integer id){
        knights.remove(id);
    }

    @Override
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
