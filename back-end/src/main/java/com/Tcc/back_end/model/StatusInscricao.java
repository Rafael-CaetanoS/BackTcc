package com.Tcc.back_end.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_statusInscricao")
public class StatusInscricao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStatusInscricao;

    private String status;

}
