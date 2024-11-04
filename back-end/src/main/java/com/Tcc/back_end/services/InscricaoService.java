package com.Tcc.back_end.services;

import com.Tcc.back_end.model.Inscricao;
import com.Tcc.back_end.model.Partida;
import com.Tcc.back_end.model.StatusInscricao;
import com.Tcc.back_end.repository.InscricaoRepository;
import com.Tcc.back_end.repository.PartidaRepository;
import com.Tcc.back_end.repository.StatusInscricaoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class InscricaoService {

    @Autowired
    private InscricaoRepository inscricaoRepository;

    @Autowired
    private PartidaRepository partidaRepository;

    @Autowired
    private StatusInscricaoRepository statusInscricaoRepository;


    public List<Inscricao> getAll() {

        return this.inscricaoRepository.findAll();
    }

    public Inscricao findById(Long id) {
        return inscricaoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Inscrição não foi encontrada."));
    }

    public Inscricao save(Inscricao inscricao) {
        Inscricao inscricaoResult = null;
        Date date = new Date(System.currentTimeMillis());

        long atletaID = inscricao.getAtleta().getIdAtleta();
        Long partidaId = inscricao.getPartida().getIdPartida();

        if(inscricaoRepository.existsByAtleta_IdAtletaAndPartida_IdPartida(atletaID, partidaId)){
            throw new IllegalStateException("O atleta já está inscrito nesta partida.");
        }


        StatusInscricao statusInscricao = statusInscricaoRepository.findById(1L)
                .orElseThrow(() -> new EntityNotFoundException("Status de Inscrição não encontrado."));


        Partida partida = partidaRepository.findById(partidaId)
                .orElseThrow(()-> new EntityNotFoundException("partida não encontrada"));
        Long numeroInscritos = inscricaoRepository.countByPartida_IdPartida(partidaId);

        if (numeroInscritos >= partida.getQtdeAtletas()) {
            throw new IllegalStateException("Número máximo de atletas já foi atingido para esta partida.");
        }

        if (inscricao.getIdInscricao() != null) {
            inscricaoResult = this.findById(inscricao.getIdInscricao());

            if (inscricaoResult != null) {
                inscricaoResult.setDataInscricao(date);
                inscricaoResult.setStatusInscricao(statusInscricao);

                inscricaoResult = inscricaoRepository.save(inscricaoResult);
            }
        } else {
            inscricao.setDataInscricao(date);
            inscricao.setStatusInscricao(statusInscricao);

            inscricaoResult = this.inscricaoRepository.save(inscricao);
        }
        return inscricaoResult;
    }

    public List<Inscricao> findInscricaoByPartidaId(Long partidaId){
        List<Inscricao> inscricoes = inscricaoRepository.findInscricoesBypartidaId(partidaId);
        if (inscricoes.isEmpty()) {
            throw new EntityNotFoundException("Nenhuma inscricao encontrada para a partida com ID: " + partidaId);
        }
        return inscricoes;
    }
}
