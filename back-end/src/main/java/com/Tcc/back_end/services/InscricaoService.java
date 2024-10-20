package com.Tcc.back_end.services;

import com.Tcc.back_end.model.Inscricao;
import com.Tcc.back_end.repository.InscricaoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InscricaoService {

    @Autowired
    private InscricaoRepository inscricaoRepository;

    public List<Inscricao> getAll() {
        return this.inscricaoRepository.findAll();
    }

    public Inscricao findById(Long id) {
        return inscricaoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Inscrição não foi encontrada."));
    }

    public Inscricao save(Inscricao inscricao) {
        Inscricao inscricaoResult = null;

        if (inscricao.getIdInscricao() != null) {
            inscricaoResult = this.findById(inscricao.getIdInscricao());

            if (inscricaoResult != null) {
                inscricaoResult.setDataInscricao(inscricao.getDataInscricao());
                inscricaoResult = inscricaoRepository.save(inscricaoResult);
            }
        } else {
            inscricaoResult = this.inscricaoRepository.save(inscricao);
        }
        return inscricaoResult;
    }
}
