package com.Tcc.back_end.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_timePartida")
public class TimePartida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTimesPartida")
    private Long id;

    private String nomeTime;

    private int qtdeAtletas;

    private int qtdePartidas;

    private int qtdeVitorias;

    @JoinColumn(name = "fk_idPartida")
    @ManyToOne
    private Partida partida;

}
