package com.Tcc.back_end.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDate;
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

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private String horaInicio;

    @Column(nullable = false)
    private String horaFim;

    @Column(nullable = false)
    private LocalDate data;

    private int qtdeAtletas;

    private String nomeLocal;

    private String endereco;

    private String cidade;

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

    @OneToMany(mappedBy = "partida")
    @JsonIgnore
    private List<TimePartida> timePartida;
}
