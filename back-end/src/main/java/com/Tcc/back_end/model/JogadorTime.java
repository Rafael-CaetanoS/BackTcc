package com.Tcc.back_end.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_jogadorTime")
public class JogadorTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idJogadorTime")
    private Long idJogadorTime;

    @Column(name = "pontosVolei")
    private int pontosVolei;

    @Column(name = "pontosBasquete")
    private int pontosBasquete;

    @Column(name = "pontosFuteVolei")
    private int pontosFuteVolei;

    @Column(name = "gols")
    private int gols;

    @JoinColumn(name = "fk_idTimePartida")
    @ManyToOne
    private TimePartida timePartida;

}
