package com.Tcc.back_end.repository;

import com.Tcc.back_end.model.Esporte;
import com.Tcc.back_end.model.Inscricao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InscricaoRepository extends JpaRepository<Inscricao, Long> {
    Optional<Inscricao> findById(Long id);
}
