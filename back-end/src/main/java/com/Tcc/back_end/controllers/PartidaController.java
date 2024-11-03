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

    //retorna partidas com status = 1 e que não foi feito pelo próprio atleta
    @GetMapping("/retornarPartida/{id}")
    public ResponseEntity<List<Partida>> retornarPartidas(@PathVariable Long id) {
        List<?> result = this.partidaService.findPartidasByStatusPartidaId(id);
        return result.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok((List<Partida>) result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Partida> buscarPartidaPorId(@PathVariable Long id) {
        var result = this.partidaService.findById(id);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/atleta/{atletaId}")
    public List<Partida> getPartidasByAtletaId(@PathVariable Long atletaId) {
        return partidaService.findPartidasByAtletaId(atletaId);
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
