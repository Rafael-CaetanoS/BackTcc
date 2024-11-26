package com.Tcc.back_end.controllers;


import com.Tcc.back_end.model.TimePartida;
import com.Tcc.back_end.services.GerenciarPartidaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gerenciar")
@CrossOrigin(origins = "http://localhost:4200")
public class GerenciarPartidaController {

    private final GerenciarPartidaService gerenciarService;


    public GerenciarPartidaController(GerenciarPartidaService gerenciarService) {
        this.gerenciarService = gerenciarService;
    }

    @PostMapping
    public ResponseEntity<List<TimePartida>> salvarTimes(@RequestBody List<TimePartida> times) {
        List<TimePartida> savedTimes = gerenciarService.salvar(times);
        return ResponseEntity.ok(savedTimes);
    }

    @PutMapping
    public ResponseEntity<List<TimePartida>> atualizarTimes(@RequestBody List<TimePartida> times) {
        List<TimePartida> savedTimes = gerenciarService.salvar(times);
        return ResponseEntity.ok(savedTimes);
    }

    @GetMapping("/{idPartida}")
    public ResponseEntity<List<TimePartida>> retornarTimesIdPartida(@PathVariable Long idPartida) {
        List<?> result = this.gerenciarService.findByIdPartida(idPartida);
        return result.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok((List<TimePartida>) result);
    }


}
