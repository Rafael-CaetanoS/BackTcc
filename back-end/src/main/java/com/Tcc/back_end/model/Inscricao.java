package com.Tcc.back_end.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_inscricao")
public class Inscricao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInscricao;

    @Column(columnDefinition = "TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInscricao;

    @ManyToOne
    @JoinColumn(name = "fk_idAtleta")
    private Atleta atleta;

    @ManyToOne
    @JoinColumn(name = "fk_idStatusInscricao")
    private StatusInscricao statusInscricao;

    @ManyToOne
    @JoinColumn(name = "fk_idPartida")
    private Partida partida;
}
