package com.Tcc.back_end.controllers;

import com.Tcc.back_end.dto.LoginRequestDTO;
import com.Tcc.back_end.dto.RegisterRequestDTO;
import com.Tcc.back_end.dto.ResponseDTO;
import com.Tcc.back_end.infra.security.TokenService;
import com.Tcc.back_end.model.Atleta;
import com.Tcc.back_end.repository.AtletaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    //poderia colocar a anotação autowired em cima de cada repository
    private final AtletaRepository atletaRepository;
    private final PasswordEncoder passwordEncoder;
    private final  TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequestDTO body){
        Atleta atleta = this.atletaRepository.findByEmail(body.email()).orElseThrow(() ->new RuntimeException("atleta não encontrado"));
        if(passwordEncoder.matches(body.senha(), atleta.getSenha())){
            String token = this.tokenService.generateToken(atleta);
            return ResponseEntity.ok(new ResponseDTO(atleta.getNomeAtleta(), token, atleta.getId()));
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterRequestDTO body){

        Optional<Atleta> atleta = this.atletaRepository.findByEmail(body.email());
        if (atleta.isEmpty()){
            Atleta newAtleta = new Atleta();
            newAtleta.setNomeAtleta(body.nomeAtleta());
            newAtleta.setEmail(body.email());
            newAtleta.setSenha(passwordEncoder.encode(body.senha()));
            newAtleta.setDataNascimento(body.dataNascimento());
            newAtleta.setApelido(body.apelido());
            newAtleta.setTelefone(body.telefone());

            this.atletaRepository.save(newAtleta);

            String token = this.tokenService.generateToken(newAtleta);
            return ResponseEntity.ok(new ResponseDTO(newAtleta.getNomeAtleta(), token, newAtleta.getId()));
        }

        return ResponseEntity.status(HttpStatus.CONFLICT).body("Atleta já registrado com este e-mail.");
    }
}
