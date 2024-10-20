package com.Tcc.back_end.controllers;

import com.Tcc.back_end.model.Esporte;
import com.Tcc.back_end.model.StatusInscricao;
import com.Tcc.back_end.services.EsporteService;
import com.Tcc.back_end.services.StatusInscricaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/statusInscricao")
public class StatusInscricaoController {

    private final StatusInscricaoService statusInscricaoService;

    public StatusInscricaoController(StatusInscricaoService statusInscricaoService) {
        this.statusInscricaoService = statusInscricaoService;
    }


    @GetMapping
    public ResponseEntity<List<StatusInscricao>> retornarStatusInscricao() {
        List<?> result = this.statusInscricaoService.getAll();
        return result.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok((List<StatusInscricao>) result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StatusInscricao> buscarStatusInscricaoPorId(@PathVariable Long id) {
        var result = this.statusInscricaoService.findById(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<?> novoStatusInscricao(@Validated @RequestBody StatusInscricao statusInscricao) {
        var response = statusInscricaoService.save(statusInscricao);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
