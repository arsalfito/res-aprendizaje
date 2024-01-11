package com.unisangil.resultados.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unisangil.resultados.model.CriteriosEvaluacionAsignatura;

@Repository
public interface RepositorioCriteriosEvaluacionAsignatura extends JpaRepository<CriteriosEvaluacionAsignatura, Long>{

}
