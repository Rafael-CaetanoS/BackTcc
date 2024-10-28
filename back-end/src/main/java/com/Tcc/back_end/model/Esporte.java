package com.Tcc.back_end.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_esporte")
public class Esporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEsporte;

    @Column(nullable = false)
    private String nomeEsporte;

    @JsonIgnore
    @OneToMany(mappedBy = "esporte")
    private List<Partida> partidas;
}
