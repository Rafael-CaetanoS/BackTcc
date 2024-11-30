package com.Tcc.back_end.dto;

import java.time.LocalDate;
import java.util.Date;

public record RegisterRequestDTO (String nomeAtleta, String email, String senha, LocalDate dataNascimento, String apelido, String telefone) {
}
