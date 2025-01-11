package com.example.SpringJpa;

import com.example.SpringJpa.Masini;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional

public class MasinaRepository {
    @PersistenceContext
    EntityManager entityManager;

    public Masini insert(Masini masina) {
        return entityManager.merge(masina);
    }

    public List<Masini> findAll() {
        TypedQuery<Masini> query = entityManager.createQuery("from Masina", Masini.class);
        return query.getResultList();
    }

    public Masini findByNr_inmatriculare(String nr_inmatriculare) {
        return entityManager.find(Masini.class, nr_inmatriculare);
    }

    public void deleteByNr_inmatriculare(String nr_inmatriculare) {
        Masini masina = findByNr_inmatriculare(nr_inmatriculare);
        if (masina != null) {
            entityManager.remove(masina);
        }
    }

    public int countByMarca(String marca) {
        TypedQuery<Masini> query = entityManager.createQuery("from Masina where marca = :marca", Masini.class);
        query.setParameter("marca", marca);
        return query.getResultList().size();
    }

    public int countByNr_kilometrii_smallerThan(int nr_kilometrii) {
        TypedQuery<Masini> query = entityManager.createQuery("from Masina where nrKilometrii < 100000", Masini.class);
        return query.getResultList().size();
    }

    public List<Masini> findMasiniNoi(int an_curent) {

        int an = an_curent - 5;
        TypedQuery<Masini> query = entityManager.createQuery("from Masina where anFabricatie >= :an", Masini.class);
        return query.setParameter("an", an).getResultList();
    }

}
