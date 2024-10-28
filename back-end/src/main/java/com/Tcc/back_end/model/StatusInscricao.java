package com.Tcc.back_end.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_statusInscricao")
public class StatusInscricao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStatusInscricao;

    @Column(nullable = false, length = 6) //7
    private String status;

    @JsonIgnore
    @OneToMany(mappedBy = "statusInscricao")
    private List<Inscricao> inscricao;

}
