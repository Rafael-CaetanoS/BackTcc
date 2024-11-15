package com.Tcc.back_end.repository;

import com.Tcc.back_end.model.JogadorTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface JogadorTimeRepository extends JpaRepository<JogadorTime, Long> {

    Optional<JogadorTime> findById(Long id);

    @Query("SELECT j FROM JogadorTime j JOIN j.timePartida t WHERE t.partida.idPartida = :idPartida")
    List<JogadorTime> findByPartidaId(@Param("idPartida") Long idPartida);
}
