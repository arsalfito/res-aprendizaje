package com.unisangil.resultados.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unisangil.resultados.model.CriteriosEvaluacion;

@Repository
public interface RepositorioCriteriosEvaluacion extends JpaRepository<CriteriosEvaluacion, Long>{
	
	@Query(value = "select * from criterios_evaluacion ce where ce.id_programa = :idPrograma and ce.estado = true", nativeQuery = true)
	public Optional<List<CriteriosEvaluacion>> findCriteriosEvaluacionPrograma(
			@Param("idPrograma") Long idPrograma);

}
