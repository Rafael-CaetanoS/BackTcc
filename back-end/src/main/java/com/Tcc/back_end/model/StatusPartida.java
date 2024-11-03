package com.Tcc.back_end.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "tb_statusPartida")
public class StatusPartida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStatusPartida;

    @Column(nullable = false, length = 20)
    private String statusPartida;

    @JsonIgnore
    @OneToMany(mappedBy = "statusPartida")
    private List<Partida> partida;

}
