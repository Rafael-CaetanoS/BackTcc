package com.Tcc.back_end.repository;

import com.Tcc.back_end.model.StatusPartida;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StatusPartidaRepository extends JpaRepository<StatusPartida, Long> {
    Optional<StatusPartida> findById(Long id);
}
