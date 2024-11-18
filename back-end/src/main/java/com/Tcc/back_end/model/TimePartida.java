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

    @JoinColumn(name = "fk_idPartida")
    @ManyToOne
    private Partida partida;

    @OneToMany(mappedBy = "timePartida")
    private List<JogadorTime> jogadores;

}
