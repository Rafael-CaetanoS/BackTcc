package com.Tcc.back_end.repository;

import com.Tcc.back_end.model.Partida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PartidaRepository extends JpaRepository<Partida, Long> {

    Optional<Partida> findById(Long id);

    @Query("SELECT p FROM Partida p INNER JOIN p.statusPartida sp WHERE p.atleta.idAtleta <> :atletaId " +
            "AND sp.idStatusPartida = 1")
    List<Partida> retornarPartidas(@Param("atletaId") Long atletaId);

    @Query("SELECT p FROM Partida p INNER JOIN p.inscricoes i WHERE i.atleta.idAtleta = :atletaId")
    List<Partida> findPartidasByInscricao(@Param("atletaId") Long atletaId);

    @Query("SELECT p FROM Partida p INNER JOIN p.atleta a WHERE a.idAtleta = :atletaId")
    List<Partida> findPartidaByAtletaId(@Param("atletaId") Long atletaId);

}
