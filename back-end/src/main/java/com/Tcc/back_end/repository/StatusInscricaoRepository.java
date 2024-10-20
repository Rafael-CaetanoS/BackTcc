package com.Tcc.back_end.repository;

import com.Tcc.back_end.model.Inscricao;
import com.Tcc.back_end.model.Partida;
import com.Tcc.back_end.model.StatusInscricao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StatusInscricaoRepository extends JpaRepository<StatusInscricao, Long> {
    Optional<StatusInscricao> findById(Long id);
}
