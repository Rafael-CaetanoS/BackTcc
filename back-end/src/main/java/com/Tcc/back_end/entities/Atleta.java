package com.Tcc.back_end.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

@Entity
@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_atleta")
public class Atleta {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "idAtleta")
    private int id;

    private String nomeAtleta;

    private String email;

    private String senha;

    private Date dataNascimento;

    private String apelido;

    private String telefone;

    private int avaliacao;

    private int pontosFutebol;

    private int pontosVolei;

    private int pontosBasquete;

    private int pontosFutevolei;

    private  String imagem;

    @OneToMany(mappedBy = "atleta")
    private List<Partida> partidas
    ;
}
