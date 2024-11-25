package com.Tcc.back_end.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JoinColumn(name = "fk_idTimePartida", nullable = false)
    @ManyToOne
    @JsonIgnore
    private TimePartida timePartida;

    @JoinColumn(name = "fk_idInscricao", nullable = false)
    @ManyToOne
    private Inscricao inscricao;

}
