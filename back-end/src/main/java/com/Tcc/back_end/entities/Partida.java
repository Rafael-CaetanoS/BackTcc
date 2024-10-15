package com.Tcc.back_end.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


import java.util.Date;
import java.util.List;

@Entity
@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_partida")
public class Partida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPartida")
    private int id;

    private String titulo;

    private String descricao;

    private String horaInicio;

    private String horaFim;

    private Date data;

    private String faixaEtaria;

    private int qtdeAtletas;

    @JoinColumn (name = "fk_idAtleta")
    @ManyToOne
    private Atleta atleta;

    @JoinColumn (name = "fk_idEsporte")
    @ManyToOne
    private Esporte esporte;




}
