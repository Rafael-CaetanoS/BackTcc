package com.Tcc.back_end.controllers;

import com.Tcc.back_end.model.Partida;
import com.Tcc.back_end.services.PartidaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/partidas")
public class PartidaController {

    private final PartidaService partidaService;

    public PartidaController(PartidaService partidaService) {
        this.partidaService = partidaService;
    }

    @GetMapping
    public ResponseEntity<List<Partida>> retornarPartidas() {
        List<?> result = this.partidaService.getAll();
        return result.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok((List<Partida>) result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Partida> buscarPartidaPorId(@PathVariable Long id) {
        var result = this.partidaService.findById(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<?> novaPartida(@Validated @RequestBody Partida partida) {
        var response = partidaService.save(partida);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping
    public ResponseEntity<?> atualizarPartida(@Validated @RequestBody Partida partida) {
        var response = partidaService.save(partida);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
