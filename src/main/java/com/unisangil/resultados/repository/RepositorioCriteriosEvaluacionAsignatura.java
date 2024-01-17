package com.unisangil.resultados.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unisangil.resultados.model.CriteriosEvaluacionAsignatura;

@Repository
public interface RepositorioCriteriosEvaluacionAsignatura extends JpaRepository<CriteriosEvaluacionAsignatura, Long>{

	@Query(value = "select * from criterios_evaluacion_asignatura cea where cea.id_asignatura = :idAsignatura "
			+ "and cea.id_resultado_aprendizaje = :idResultadoAprend and cea.estado = true", nativeQuery = true)
	public Optional<List<CriteriosEvaluacionAsignatura>> findCriteriosEvaluacionAsignatura(
			@Param("idAsignatura") Long idAsignatura, @Param("idResultadoAprend") Long idResultadoAprend);
	
	@Query(value = "select * from criterios_evaluacion_asignatura cea "
			+ "where cea.id_asignatura = :idAsignatura "
			+ "and cea.id_resultado_aprendizaje = :idResultado "
			+ "and cea.id_criterio_evaluacion  = :idCriterio", nativeQuery = true)
	public Optional<CriteriosEvaluacionAsignatura> findCriteriosEvaluacionAsignaturaResultadoCriterio(
			@Param("idAsignatura") Long idAsignatura, 
			@Param("idResultado") Long idResultado,
			@Param("idCriterio") Long idCriterio);
	
}
