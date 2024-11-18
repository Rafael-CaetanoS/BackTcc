package com.Tcc.back_end.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_jogadorTime")
public class JogadorTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idJogadorTime")
    private Long idJogadorTime;

    @JoinColumn(name = "fk_idTimePartida")
    @ManyToOne
    private TimePartida timePartida;

    @JoinColumn(name = "fk_idInscricao")
    @ManyToOne
    private Inscricao inscricao;

}
