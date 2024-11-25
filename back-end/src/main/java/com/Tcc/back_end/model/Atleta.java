package com.Tcc.back_end.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "tb_atleta")
public class Atleta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAtleta")
    private Long idAtleta;

    @Column(nullable = false,length = 100 )
    private String nomeAtleta;

    @Column(nullable = false, length = 150)
    private String email;

    @Column(nullable = false, length = 300)
    private String senha;

    @Column(nullable = false)
    private Date dataNascimento;

    @Column(nullable = false, length = 20)
    private String apelido;

    @Column(nullable = false, length = 11)
    private String telefone;

    private String imagem;

    @JsonIgnore
    @OneToMany(mappedBy = "atleta")
    private List<Partida> partidas;
}
