package com.Tcc.back_end.services;

import com.Tcc.back_end.model.Atleta;
import com.Tcc.back_end.repository.AtletaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AtletaService {

    @Autowired
    private AtletaRepository atletaRepository;

    public List<Atleta> getAll() {
        return this.atletaRepository.findAll();
    }

    public Atleta findById(Long id) {
        return this.atletaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("O atleta não foi encontrado."));
    }

    public Atleta save(Atleta atleta) {
        Atleta atletaResult = null;

        if (atleta.getId() != null) {
            atletaResult = this.findById(atleta.getId());

            if (atletaResult != null) {
                atletaResult.setNomeAtleta(atleta.getNomeAtleta());
                atletaResult.setEmail(atleta.getEmail());
                atletaResult.setSenha(atleta.getSenha());
                atletaResult.setDataNascimento(atleta.getDataNascimento());
                atletaResult.setApelido(atleta.getApelido());
                atletaResult.setTelefone(atleta.getTelefone());

                atletaResult = this.atletaRepository.save(atletaResult);
            }
        } else {
            atletaResult = this.atletaRepository.save(atleta);
        }
        return atletaResult;
    }

    public boolean validarLogin(String email, String senha) {

        Optional<Atleta> atletaOptional = Optional.ofNullable(atletaRepository.findByEmail(email));

        if (atletaOptional.isPresent()) {
            Atleta atleta = atletaOptional.get();
            return atleta.getSenha().equals(senha);
        }
        return false;
    }
}
