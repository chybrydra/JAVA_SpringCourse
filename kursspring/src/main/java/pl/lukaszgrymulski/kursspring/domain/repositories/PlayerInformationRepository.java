package pl.lukaszgrymulski.kursspring.domain.repositories;

import org.springframework.stereotype.Repository;
import pl.lukaszgrymulski.kursspring.domain.PlayerInformation;
import pl.lukaszgrymulski.kursspring.domain.Quest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class PlayerInformationRepository {

    @PersistenceContext
    EntityManager em;

    @Transactional
    public void createPlayerInformation(PlayerInformation playerInformation) {
        PlayerInformation pi = new PlayerInformation();
        em.persist(pi);
    }

    public PlayerInformation getFirst() {
        return em.createQuery("from PlayerInformation", PlayerInformation.class).getResultList().get(0);
    }
}
