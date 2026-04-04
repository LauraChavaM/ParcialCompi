package com.example.enanospeleadores2.peleas.repository;

import com.example.enanospeleadores2.peleas.model.Pelea;
import com.example.enanospeleadores2.peleador.model.Peleador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface PeleasRepository extends JpaRepository<Pelea, Long> {

    List<Pelea> findByPeleadoresContains(Peleador peleador);

    List<Pelea> findByGanador(Peleador ganador);

    List<Pelea> findByFechaBetween(LocalDateTime inicio, LocalDateTime fin);
}