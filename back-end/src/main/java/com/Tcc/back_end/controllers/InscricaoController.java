package com.Tcc.back_end.controllers;

import com.Tcc.back_end.model.Inscricao;
import com.Tcc.back_end.model.Partida;
import com.Tcc.back_end.services.InscricaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inscricao")
public class InscricaoController {

    private final InscricaoService inscricaoService;

    public InscricaoController(InscricaoService inscricaoService) {
        this.inscricaoService = inscricaoService;
    }

    @GetMapping
    public ResponseEntity<List<Inscricao>> retornarInscricao() {
        List<?> result = this.inscricaoService.getAll();
        return result.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok((List<Inscricao>) result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inscricao> buscarInscricaoPorId(@PathVariable Long id) {
        var result = this.inscricaoService.findById(id);
        return ResponseEntity.ok(result);
    }
    @GetMapping("/partida/{idPartida}")
    public ResponseEntity<List<Inscricao>> buscarInscricaoPorIdPartida(@PathVariable Long idPartida) {
        List<Inscricao> inscricoes = inscricaoService.findInscricaoByPartidaId(idPartida);
        return ResponseEntity.ok(inscricoes);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<?> novaInscricao(@Validated @RequestBody Inscricao inscricao) {
        var response = inscricaoService.save(inscricao);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
