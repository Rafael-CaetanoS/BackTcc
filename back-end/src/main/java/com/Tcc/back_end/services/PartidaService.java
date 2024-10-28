package com.Tcc.back_end.services;

import com.Tcc.back_end.model.Partida;
import com.Tcc.back_end.repository.PartidaRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class PartidaService {

    @Autowired
    private PartidaRepository partidaRepository;

    public List<Partida> getAll() {
        return this.partidaRepository.findAll();
    }

    public Partida findById(Long id) {
        return partidaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("A partida não foi encontrada."));
    }

    public Partida save(Partida partida) {
        Partida partidaResult = null;

        if (partida.getIdPartida() != null) {
            partidaResult = this.findById(partida.getIdPartida());

            if (partidaResult != null) {
                partidaResult.setTitulo(partida.getTitulo());
                partidaResult.setDescricao(partida.getDescricao());
                partidaResult.setHoraInicio(partida.getHoraInicio());
                partidaResult.setHoraFim(partida.getHoraFim());
                partidaResult.setData(partida.getData());
                partidaResult.setFaixaEtaria(partida.getFaixaEtaria());
                partidaResult.setQtdeAtletas(partida.getQtdeAtletas());
                partidaResult.setNomeLocal(partida.getNomeLocal());
                partidaResult.setEndereco(partida.getEndereco());

                partidaResult = partidaRepository.save(partidaResult);
            }
        } else {
            partidaResult = this.partidaRepository.save(partida);
        }

        return partidaResult;
    }

}
