package com.Tcc.back_end.controllers;

import com.Tcc.back_end.model.StatusInscricao;
import com.Tcc.back_end.model.StatusPartida;
import com.Tcc.back_end.services.StatusInscricaoService;
import com.Tcc.back_end.services.StatusPartidaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/statusPartida")
public class StatusPartidaController {

    private final StatusPartidaService statusPartidaService;

    public StatusPartidaController(StatusPartidaService statusPartidaService) {
        this.statusPartidaService = statusPartidaService;
    }


    @GetMapping
    public ResponseEntity<List<StatusPartida>> retornarStatusPartida() {
        List<?> result = this.statusPartidaService.getAll();
        return result.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok((List<StatusPartida>) result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StatusPartida> buscarStatusPartidaPorId(@PathVariable Long id) {
        var result = this.statusPartidaService.findById(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<?> novoStatusPartida(@Validated @RequestBody StatusPartida statusPartida) {
        var response = statusPartidaService.save(statusPartida);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
