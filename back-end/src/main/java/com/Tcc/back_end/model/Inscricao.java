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

    private Date dataInscricao;

    @JoinColumn(name = "fk_idAtleta")
    @ManyToOne
    private Atleta atleta;

    @JoinColumn(name = "fk_idStatusInscricao")
    @ManyToOne
    private StatusInscricao statusInscricao;

    @JoinColumn(name = "fk_idPartida")
    @ManyToOne
    private Partida partida;
}
