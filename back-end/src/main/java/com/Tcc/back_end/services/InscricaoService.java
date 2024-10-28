package com.Tcc.back_end.services;

import com.Tcc.back_end.model.Inscricao;
import com.Tcc.back_end.model.StatusInscricao;
import com.Tcc.back_end.repository.InscricaoRepository;
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
        StatusInscricao statusInscricao = statusInscricaoRepository.findById(1L)
                .orElseThrow(() -> new EntityNotFoundException("Status de Inscrição não encontrado."));

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
}
