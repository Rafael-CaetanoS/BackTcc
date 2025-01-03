package com.Tcc.back_end.repository;

import com.Tcc.back_end.model.Partida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PartidaRepository extends JpaRepository<Partida, Long> {

    Optional<Partida> findById(Long id);

    @Query("SELECT p FROM Partida p INNER JOIN p.statusPartida sp " +
            "WHERE p.atleta.idAtleta <> :atletaId " +
            "AND (SELECT COUNT(insc.idInscricao) FROM Inscricao insc WHERE insc.partida.idPartida = p.idPartida and insc.statusInscricao.idStatusInscricao =1) < p.qtdeAtletas " +
            "AND (p.idPartida NOT IN (" +
            "    SELECT ins.partida.idPartida FROM Inscricao ins " +
            "    WHERE ins.atleta.idAtleta = :atletaId " +
            "    AND ins.statusInscricao.idStatusInscricao IN (1, 3)" +
            ") OR NOT EXISTS (" +
            "    SELECT ins FROM Inscricao ins " +
            "    WHERE ins.partida.idPartida = p.idPartida AND ins.atleta.idAtleta = :atletaId" +
            ")) " +
            "AND sp.idStatusPartida = 1")
    List<Partida> retornarPartidas(@Param("atletaId") Long atletaId);
    @Query("SELECT p FROM Partida p INNER JOIN p.inscricoes i WHERE i.atleta.idAtleta = :atletaId and i.statusInscricao.idStatusInscricao =1")
    List<Partida> findPartidasByInscricao(@Param("atletaId") Long atletaId);

    @Query("SELECT p FROM Partida p INNER JOIN p.atleta a INNER JOIN p.statusPartida sp WHERE a.idAtleta = :atletaId AND sp.idStatusPartida = 1")
    List<Partida> findPartidaByAtletaId(@Param("atletaId") Long atletaId);

}
