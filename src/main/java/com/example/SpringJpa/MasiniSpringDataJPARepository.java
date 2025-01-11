package com.example.SpringJpa;

import com.example.SpringJpa.Masini;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MasiniSpringDataJPARepository extends JpaRepository<Masini, String> {

    List<Masini> findByAnFabricatieGreaterThan(int anFabricatie);

    int countByMarca(String marca);

    String insert(Masini masini);

    void deleteByNr_inmatriculare(String nrInmatriculare);

    boolean findByNr_inmatriculare(String nrInmatriculare);

    Iterable<Object> findMasiniNoi(int year);

    String countByNr_kilometrii(int i);
}
