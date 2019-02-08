package pl.lukaszgrymulski.kursspring.domain.repositories;

import pl.lukaszgrymulski.kursspring.domain.Knight;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.Optional;


public class DBKnightRepository implements KnightRepository {

    @Override
    public void createKnight(String name, int age){
        System.out.println("uzywam bazy danych");
        throw new NotImplementedException();
    }

    @Override
    public Collection<Knight> getAllKnights(){
        System.out.println("uzywam bazy danych");
        throw new NotImplementedException();
    }

    @Override
    public Optional<Knight> getKnight(String name){
        System.out.println("uzywam bazy danych");
        throw new NotImplementedException();
    }

    @Override
    public void deleteKnight(Integer id){
        System.out.println("uzywam bazy danych");
        throw new NotImplementedException();
    }

    @Override
    @PostConstruct
    public void build(){

    }

    @Override
    public void createKnight(Knight knight) {
        System.out.println("uzywam bazy danych");
        throw new NotImplementedException();
    }

    @Override
    public Knight getKnightById(Integer id) {
        System.out.println("uzywam bazy danych");
        throw new NotImplementedException();
    }
}
