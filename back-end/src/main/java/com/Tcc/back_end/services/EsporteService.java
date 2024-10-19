package com.Tcc.back_end.services;

import com.Tcc.back_end.model.Esporte;
import com.Tcc.back_end.repository.EsporteRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EsporteService {

    @Autowired
    private EsporteRepository esporteRepository;

    public List<Esporte> getAll() {
        return this.esporteRepository.findAll();
    }

    public Esporte findById(Long id) {
        return this.esporteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("O Esporte não foi encontrado."));
    }

    public Esporte save(Esporte esporte) {
        Esporte esporteResult = null;

        if (esporte.getIdEsporte() != null) {
            esporteResult = this.findById(esporte.getIdEsporte());

            if (esporteResult != null) {
                esporteResult.setNomeEsporte(esporte.getNomeEsporte());

                esporteResult = this.esporteRepository.save(esporteResult);
            }
        }else{
            esporteResult = this.esporteRepository.save(esporte);
        }

        return esporteResult;
    }
}
