package com.unisangil.resultados.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unisangil.resultados.model.Programa;

@Repository
public interface RepositorioPrograma extends JpaRepository<Programa, Long>{

}
