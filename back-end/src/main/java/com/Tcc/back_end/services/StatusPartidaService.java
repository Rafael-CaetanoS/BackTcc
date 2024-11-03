package com.Tcc.back_end.services;

import com.Tcc.back_end.model.StatusInscricao;
import com.Tcc.back_end.model.StatusPartida;
import com.Tcc.back_end.repository.StatusPartidaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusPartidaService {

    @Autowired
    private StatusPartidaRepository statusPartidaRepository;

    public List<StatusPartida> getAll() {
        return this.statusPartidaRepository.findAll();
    }

    public StatusPartida findById(Long id) {
        return statusPartidaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("O status não foi encontrado."));
    }

    public StatusPartida save(StatusPartida statusPartida) {
        StatusPartida statusPartidaResult = null;

        if (statusPartida.getIdStatusPartida() != null) {
            statusPartidaResult = this.findById(statusPartida.getIdStatusPartida());

            if (statusPartidaResult != null) {
                statusPartidaResult.setStatusPartida(statusPartida.getStatusPartida());

                statusPartidaResult = statusPartidaRepository.save(statusPartida);
            }
        } else {
            statusPartidaResult = this.statusPartidaRepository.save(statusPartida);
        }

        return statusPartidaResult;
    }

}
