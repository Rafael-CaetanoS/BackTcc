package com.Tcc.back_end.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_esporte")
public class Esporte {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idEsporte;

    private String nomeEsporte;

    @OneToMany(mappedBy = "esporte")
    private List<Partida> partidas;
}
