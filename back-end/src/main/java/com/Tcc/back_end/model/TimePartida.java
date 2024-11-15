package com.Tcc.back_end.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_timePartida")
public class TimePartida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTimePartida")
    private Long idTimePartida;

    private String nomeTime;

    private int qtdeAtletas;

    private int qtdePartidas;

    private int qtdeVitorias;

    @JoinColumn(name = "fk_idPartida")
    @ManyToOne
    private Partida partida;

    @OneToMany(mappedBy = "timePartida")
    @JsonIgnore
    private List<JogadorTime> jogadores;

    public TimePartida(Long idTimePartida, String nomeTime) {
        this.idTimePartida = idTimePartida;
        this.nomeTime = nomeTime;
    }
}
