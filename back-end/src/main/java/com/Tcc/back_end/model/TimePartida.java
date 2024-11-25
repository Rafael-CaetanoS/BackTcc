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

    @Column(nullable = false, length = 45)
    private String nomeTime;

    @Column(nullable = false, columnDefinition = "BIGINT DEFAULT 0")
    private Long totalPontos;

    @JoinColumn(name = "fk_idPartida", nullable = false)
    @ManyToOne
    private Partida partida;

    @OneToMany(mappedBy = "timePartida")
    private List<JogadorTime> jogadores;

}
