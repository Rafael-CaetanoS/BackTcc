package com.Tcc.back_end.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;


import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_partida")
public class Partida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPartida")
    private Long idPartida;

    @Column(nullable = false, length = 45)
    private String titulo;

    @Column(nullable = false, length = 150)
    private String descricao;

    @Column(nullable = false, length = 5)
    private String horaInicio;

    @Column(nullable = false, length = 5)
    private String horaFim;

    @Column(nullable = false)
    private Date data;

    @Column(nullable = false)
    private int qtdeAtletas;

    @Column(nullable = false, length = 45)
    private String nomeLocal;

    @Column(nullable = false, length = 150)
    private String endereco;

    @Column(nullable = false, length = 50)
    private String cidade;

    @JoinColumn(name = "fk_idAtleta",nullable = false)
    @ManyToOne
    private Atleta atleta;

    @JoinColumn(name = "fk_idEsporte" ,nullable = false)
    @ManyToOne
    private Esporte esporte;

    @OneToMany(mappedBy = "partida")
    @JsonIgnore // Ignorar este campo na serialização JSON
    private List<Inscricao> inscricoes; // Relacionamento com as inscrições

    @JoinColumn(name = "fk_statusPartida",nullable = false)
    @ManyToOne
    private StatusPartida statusPartida;

    @OneToMany(mappedBy = "partida")
    @JsonIgnore
    private List<TimePartida> timePartida;
}
