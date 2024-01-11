package com.unisangil.resultados.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unisangil.resultados.model.ResultadoAprendizaje;

@Repository
public interface RepositorioResultadoAprendizaje extends JpaRepository<ResultadoAprendizaje, Long>{

}
