package com.Tcc.back_end.dto;

import com.Tcc.back_end.model.Atleta;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginDTO {

    private String email;
    private String senha;

    public Atleta toAtleta() {
        Atleta atleta = new Atleta();
        atleta.setEmail(this.email);
        atleta.setSenha(this.senha);
        return atleta;
    }
}
