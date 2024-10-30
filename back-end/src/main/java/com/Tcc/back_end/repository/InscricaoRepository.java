package com.Tcc.back_end.repository;

import com.Tcc.back_end.model.Esporte;
import com.Tcc.back_end.model.Inscricao;
import com.Tcc.back_end.model.Partida;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface InscricaoRepository extends JpaRepository<Inscricao, Long> {
    Optional<Inscricao> findById(Long id);

    long countByPartida_IdPartida(Long partidaId);

    boolean existsByAtleta_IdAtletaAndPartida_IdPartida(Long atletaId, Long partidaId);

    @Query("SELECT i FROM Inscricao i INNER JOIN i.partida p WHERE p.idPartida = :idPartida")
    List<Inscricao> findInscricoesBypartidaId(@Param("idPartida") Long idPartida);
}
