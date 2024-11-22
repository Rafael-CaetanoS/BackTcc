package com.Tcc.back_end.dto;

import java.time.LocalDate;
import java.util.Date;

public record RegisterRequestDTO (String nomeAtleta, String email, String senha, Date dataNascimento, String apelido, String telefone) {
}
