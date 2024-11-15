package com.Tcc.back_end.repository;

import com.Tcc.back_end.model.TimePartida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TimePartidaRepository extends JpaRepository<TimePartida, Long> {
    Optional<TimePartida> findById(Long id);

    @Query("SELECT t FROM TimePartida t WHERE t.partida.idPartida = :idPartida")
    List<TimePartida> findByPartidaId(@Param("idPartida") Long idPartida);
}
