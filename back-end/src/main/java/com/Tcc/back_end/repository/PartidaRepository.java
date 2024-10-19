package com.Tcc.back_end.repository;

import com.Tcc.back_end.model.Atleta;
import com.Tcc.back_end.model.Partida;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PartidaRepository extends JpaRepository<Partida, Long> {

    Optional<Partida> findById(Long id);
}
