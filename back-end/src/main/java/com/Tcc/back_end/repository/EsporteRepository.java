package com.Tcc.back_end.repository;

import com.Tcc.back_end.model.Atleta;
import com.Tcc.back_end.model.Esporte;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EsporteRepository extends JpaRepository<Esporte, Long> {

    Optional<Esporte> findById(Long id);
}
