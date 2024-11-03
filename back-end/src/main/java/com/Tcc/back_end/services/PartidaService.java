package com.Tcc.back_end.services;

import com.Tcc.back_end.model.Inscricao;
import com.Tcc.back_end.model.Partida;
import com.Tcc.back_end.model.StatusPartida;
import com.Tcc.back_end.repository.PartidaRepository;
import com.Tcc.back_end.repository.StatusPartidaRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class PartidaService {

    @Autowired
    private PartidaRepository partidaRepository;

    @Autowired
    private InscricaoService inscricaoService;
    @Autowired
    private StatusPartidaRepository statusPartidaRepository;

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
            partidaResult = partida;

            StatusPartida statusPartida = new StatusPartida();
            statusPartida.setIdStatusPartida(1L);
            partidaResult.setStatusPartida(statusPartida);

            partidaResult = this.partidaRepository.save(partida);

            Inscricao inscricao = new Inscricao();
            inscricao.setAtleta(partida.getAtleta());
            inscricao.setPartida(partidaResult);

            inscricaoService.save(inscricao);
        }

        return partidaResult;
    }


    public List<Partida> findPartidasByAtletaId(Long atletaId) {
        List<Partida> partidas = partidaRepository.findPartidasByInscricao(atletaId);
        if (partidas.isEmpty()) {
            throw new EntityNotFoundException("Nenhuma partida encontrada para o atleta com ID: " + atletaId);
        }
        return partidas;
    }

    public List<Partida> findPartidasByStatusPartidaId(Long atletaId) {
        List<Partida> partidas = partidaRepository.retornarPartidas(atletaId);
        if (partidas.isEmpty()) {
            throw new EntityNotFoundException("Nenhuma partida encontrada foi encontrada");
        }
        return partidas;
    }

}
