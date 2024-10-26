package com.Tcc.back_end.controllers;

import com.Tcc.back_end.model.Atleta;
import com.Tcc.back_end.services.AtletaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/atletas")
public class AtletaController {

    private final AtletaService atletaService;

    public AtletaController(AtletaService atletaService) {
        this.atletaService = atletaService;
    }

    @GetMapping
    public ResponseEntity<List<Atleta>> retornarAtletas() {
        List<?> result = this.atletaService.getAll();
        return result.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok((List<Atleta>) result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Atleta> buscarAtletaPorId(@PathVariable Long id) {
        var result = this.atletaService.findById(id);
        return ResponseEntity.ok(result);
    }

//    @PostMapping
//    @ResponseBody
//    public ResponseEntity<?> novoAtleta(@Validated @RequestBody Atleta atleta) {
//        var response = atletaService.save(atleta);
//        return ResponseEntity.status(HttpStatus.CREATED).body(response);
//    }

    @PutMapping
    public ResponseEntity<?> atualizarAtleta(@Validated @RequestBody Atleta atleta) {
        var response = atletaService.save(atleta);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
