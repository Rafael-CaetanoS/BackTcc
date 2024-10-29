package com.Tcc.back_end.repository;

import com.Tcc.back_end.model.Atleta;
import com.Tcc.back_end.model.Partida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PartidaRepository extends JpaRepository<Partida, Long> {

    Optional<Partida> findById(Long id);

    @Query("SELECT p FROM Partida p INNER JOIN p.inscricoes i WHERE i.atleta.id = :atletaId")
    List<Partida> findPartidasByAtletaId(@Param("atletaId") Long atletaId);

}
