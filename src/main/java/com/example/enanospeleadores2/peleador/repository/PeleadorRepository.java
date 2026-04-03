package com.example.enanospeleadores2.peleador.repository;

import com.example.enanospeleadores2.peleador.model.Peleador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PeleadorRepository extends JpaRepository<Peleador, Long> {

    Optional<Peleador> findByName(String name);
}
