package com.Tcc.back_end.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;


import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_partida")
public class Partida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPartida")
    private Long idPartida;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private String horaInicio;

    @Column(nullable = false)
    private String horaFim;

    @Column(nullable = false)
    private Date data;

    private String faixaEtaria;

    private int qtdeAtletas;

    private String nomeLocal;

    private String endereco;

    @JoinColumn(name = "fk_idAtleta")
    @ManyToOne
    private Atleta atleta;

    @JoinColumn(name = "fk_idEsporte")
    @ManyToOne
    private Esporte esporte;

    @OneToMany(mappedBy = "partida")
    @JsonIgnore // Ignorar este campo na serialização JSON
    private List<Inscricao> inscricoes; // Relacionamento com as inscrições

    @JoinColumn(name = "fk_statusPartida")
    @ManyToOne
    private StatusPartida statusPartida;
}
