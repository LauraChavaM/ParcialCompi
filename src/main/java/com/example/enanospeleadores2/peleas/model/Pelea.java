package com.example.enanospeleadores2.peleas.model;

import com.example.enanospeleadores2.peleador.model.Peleador;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "pelea")
@Data
public class Pelea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(
            name = "pelea_peleador",
            joinColumns = @JoinColumn(name = "pelea_id"),
            inverseJoinColumns = @JoinColumn(name = "peleador_id")
    )
    private List<Peleador> peleadores;

    @ManyToOne
    @JoinColumn(name = "ganador_id")
    private Peleador ganador;

    @Column(nullable = false)
    private LocalDateTime fecha;

    @Column(length = 500)
    private String resumen;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pelea pelea = (Pelea) o;
        return Objects.equals(id, pelea.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}