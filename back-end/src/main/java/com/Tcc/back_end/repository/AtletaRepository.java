package com.Tcc.back_end.repository;

import com.Tcc.back_end.model.Atleta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AtletaRepository extends JpaRepository<Atleta, Long> {

    Optional<Atleta> findById(Long id);

    Optional<Atleta> findByEmail(String email);

}
