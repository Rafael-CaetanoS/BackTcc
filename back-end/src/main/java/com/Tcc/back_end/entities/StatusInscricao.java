package com.Tcc.back_end.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_statusInscricao")
public class StatusInscricao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idStatusInscricao;

    private String status;

}
