package com.Tcc.back_end.dto;

import com.Tcc.back_end.model.Partida;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AtletaDTO  implements Serializable {

    private Long id;

    private String nomeAtleta;

    private String email;

    private String senha;

    private Date dataNascimento;

    private String apelido;

    private String telefone;

    private int avaliacao = 100;

    private int pontosFutebol = 0;

    private int pontosVolei = 0;

    private int pontosBasquete = 0;

    private int pontosFutevolei = 0;

    private  String imagem;

    private List<Partida> partidas;

}
