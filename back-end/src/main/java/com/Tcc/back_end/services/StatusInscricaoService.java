package com.Tcc.back_end.services;

import com.Tcc.back_end.model.Partida;
import com.Tcc.back_end.model.StatusInscricao;
import com.Tcc.back_end.repository.StatusInscricaoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusInscricaoService {
    @Autowired
    private StatusInscricaoRepository statusInscricaoRepository;

    public List<StatusInscricao> getAll() {
        return this.statusInscricaoRepository.findAll();
    }

    public StatusInscricao findById(Long id) {
        return statusInscricaoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("O status não foi encontrado."));
    }

    public StatusInscricao save(StatusInscricao statusInscricao) {
        StatusInscricao statusInscricaoResult = null;

        if (statusInscricao.getIdStatusInscricao() != null) {
            statusInscricaoResult = this.findById(statusInscricao.getIdStatusInscricao());

            if (statusInscricaoResult != null) {
                statusInscricaoResult.setStatus(statusInscricao.getStatus());


                statusInscricaoResult = statusInscricaoRepository.save(statusInscricao);
            }
        } else {
            statusInscricaoResult = this.statusInscricaoRepository.save(statusInscricao);
        }

        return statusInscricaoResult;
    }

}
