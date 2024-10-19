package com.Tcc.back_end.controllers;

import com.Tcc.back_end.dto.LoginDTO;
import com.Tcc.back_end.model.Atleta;
import com.Tcc.back_end.services.AtletaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private AtletaService atletaService;

    @GetMapping
    public String index () {
        return "login/index";
    }

    //vai colocar no front uma action="/logar" e method="POST"
    @PostMapping("/logar")
    public String logar (@ModelAttribute LoginDTO loginDTO, Model model) {
        Atleta atleta = loginDTO.toAtleta();
        model.addAttribute("email", atleta.getEmail());
        model.addAttribute("senha", atleta.getSenha());

        boolean loginValido = atletaService.validarLogin(atleta.getEmail(), atleta.getSenha());

        if (loginValido) {
            model.addAttribute("mensagem", "Login efetuado com sucesso!");
            return "início"; //verificar no front os nomes dos arquivos
        } else {
            model.addAttribute("erro", "E-mail/Senha inválidos");
            return "login"; //verificar no front os nomes dos arquivos
        }
    }

//    public ResponseEntity<?> logar (@RequestBody LoginDTO loginDTO) {
////        Atleta atleta = loginDTO.toAtleta();
////        model.addAttribute("email", atleta.getEmail());
////        model.addAttribute("senha", atleta.getSenha());
//
//        Long loginValido = atletaService.validarLogin(loginDTO.getEmail(), loginDTO.getSenha());
//
//        return (loginValido != null) ? new ResponseEntity<>(loginValido, HttpStatus.OK)
//                : new ResponseEntity<String>("Nome de usuário ou senha incorreto", HttpStatus.NOT_FOUND);
//    }

}
