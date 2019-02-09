package pl.lukaszgrymulski.kursspring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.lukaszgrymulski.kursspring.domain.Knight;
import pl.lukaszgrymulski.kursspring.domain.repositories.KnightRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class KnightService {

    @Autowired
    KnightRepository repository;

    public List<Knight> getAllKnights(){
        return new ArrayList<>(repository.getAllKnights());
    }

    public void saveKnight(Knight knight) {
        repository.createKnight(knight);
    }

    public Knight getKnight(Integer id) {
        return repository.getKnightById(id);
    }

    public void deleteKnight(Integer id) {
        repository.deleteKnight(id);
    }

    public void updateKnight(Knight knight) {
        repository.updateKnight(knight.getId(), knight);
    }
}
