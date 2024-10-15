package com.Tcc.back_end.controllers;

import com.Tcc.back_end.entities.Atleta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.Tcc.back_end.repository.AtletaRepository;
import java.util.Optional;

@RestController
@RequestMapping("/atleta")
public class AtletaController {

    @Autowired
    private AtletaRepository repository;

    @PostMapping
    @ResponseBody
    public Atleta novoAtleta(@Validated @RequestBody Atleta atleta) {
        this.repository.save(atleta);
        return atleta;
    }

    @GetMapping
    public Iterable<Atleta> retornarAtletas() {
        return this.repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Atleta> obterAtletaPorId(@PathVariable int id) {
        return this.repository.findById(id);
    }
}
