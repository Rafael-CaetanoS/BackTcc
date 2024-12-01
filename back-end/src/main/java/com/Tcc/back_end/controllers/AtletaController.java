package com.Tcc.back_end.controllers;

import com.Tcc.back_end.model.Atleta;
import com.Tcc.back_end.repository.AtletaRepository;
import com.Tcc.back_end.services.AtletaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/atletas")
public class AtletaController {

    private final AtletaService atletaService;
    private final AtletaRepository atletaRepository;

    public AtletaController(AtletaService atletaService, AtletaRepository atletaRepository) {
        this.atletaService = atletaService;
        this.atletaRepository = atletaRepository;
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
        // Verifica se o e-mail já está registrado para outro atleta
        Optional<Atleta> atletaEmail = atletaRepository.findByEmail(atleta.getEmail());
        Optional<Atleta> atletaExistente = atletaRepository.findById(atleta.getIdAtleta());

        if (atletaExistente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Atleta não encontrado.");
        }

        // Verifica se o e-mail pertence a outro atleta
        if (atletaEmail.isPresent() && !atletaEmail.get().getIdAtleta().equals(atleta.getIdAtleta())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("E-mail já registrado para outro atleta.");
        }

        // Atualiza os dados do atleta
        Atleta atletaAtualizado = atletaService.save(atleta);
        return ResponseEntity.status(HttpStatus.OK).body(atletaAtualizado);
    }

}
