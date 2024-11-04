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

    //busca a partida pelo id dela
    @GetMapping("/{id}")
    public ResponseEntity<Partida> buscarPartidaPorId(@PathVariable Long id) {
        var result = this.partidaService.findById(id);
        return ResponseEntity.ok(result);
    }

    //retorna partidas com status = 1 e que não foi criada pelo próprio atleta
    @GetMapping("/retornarPartida/{idAtleta}")
    public ResponseEntity<List<Partida>> retornarPartidas(@PathVariable Long idAtleta) {
        List<?> result = this.partidaService.findPartidasByStatusPartidaId(idAtleta);
        return result.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok((List<Partida>) result);
    }

    //retorna as partidas que o atleta tá inscrito
    @GetMapping("/inscricao/{atletaId}")
    public List<Partida> getPartidasByInscricaoId(@PathVariable Long atletaId) {
        return partidaService.findPartidasByInscricaoId(atletaId);
    }

    //retorna as partidas criadas pelo usuario.
    @GetMapping("/minhasPartidas/{atletaId}")
    public List<Partida> getPartidasByAtletaId(@PathVariable Long atletaId) {
        return partidaService.findPartidaByAtletaId(atletaId);
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
