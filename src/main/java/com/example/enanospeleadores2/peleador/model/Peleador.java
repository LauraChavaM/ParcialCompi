package com.example.enanospeleadores2.peleador.model;

import com.example.enanospeleadores2.peleas.model.Pelea;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="peleador")
@Data
public class Peleador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String name;

    @Column(nullable = false, length = 500)
    private String biografia;

    @Column(nullable = false, length = 500)
    private String historia;

    @Column(nullable = false)
    private Integer nivel;

    @Column(nullable = false)
    private Integer fuerza;

    @Column(nullable = false)
    private Integer defensa;

    @Column(nullable = false)
    private Integer velocidad;

    @Column(nullable = false)
    private Integer resistencia;

    @ManyToMany(mappedBy = "peleadores")
    private List<Pelea> peleas;

    @Transient
    public List<Pelea> getPeleasGanadas() {
        if (peleas == null) {
            return List.of();
        }
        return peleas.stream()
                .filter(pelea -> this.equals(pelea.getGanador()))
                .toList();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Peleador peleador = (Peleador) o;
        return Objects.equals(id, peleador.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}