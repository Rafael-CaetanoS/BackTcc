package com.Tcc.back_end.dto;

import com.Tcc.back_end.model.Atleta;
import com.Tcc.back_end.model.Esporte;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartidaDTO implements Serializable {

    private Long id;

    private String titulo;

    private String descricao;

    private String horaInicio;

    private String horaFim;

    private Date data;

    private String faixaEtaria;

    private int qtdeAtletas;

    private List<Atleta> atletas;

    private List<Esporte> esportes;
}
