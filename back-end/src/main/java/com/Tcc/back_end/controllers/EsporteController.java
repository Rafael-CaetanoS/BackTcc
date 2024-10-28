package com.Tcc.back_end.controllers;

import com.Tcc.back_end.model.Esporte;
import com.Tcc.back_end.model.Partida;
import com.Tcc.back_end.repository.EsporteRepository;
import com.Tcc.back_end.services.EsporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//"not-null property references a null or transient value : com.Tcc.back_end.model.Esporte.nomeEsporte",

@RestController
@RequestMapping("/esportes")
@CrossOrigin(origins = "http://localhost:4200")
public class EsporteController {

    private final EsporteService esporteService;

    public EsporteController(EsporteService esporteService) {
        this.esporteService = esporteService;
    }


    @GetMapping
    public ResponseEntity<List<Esporte>> retornarEsportes() {
        List<?> result = this.esporteService.getAll();
        return result.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok((List<Esporte>) result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Esporte> buscarEsportePorId(@PathVariable Long id) {
        var result = this.esporteService.findById(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<?> novoEsporte(@Validated @RequestBody Esporte esporte) {
        var response = esporteService.save(esporte);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping
    public ResponseEntity<?> atualizarEsporte(@Validated @RequestBody Esporte esporte) {
        var response = esporteService.save(esporte);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
