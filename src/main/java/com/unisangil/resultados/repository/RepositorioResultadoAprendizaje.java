package com.unisangil.resultados.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unisangil.resultados.model.ResultadoAprendizaje;

@Repository
public interface RepositorioResultadoAprendizaje extends JpaRepository<ResultadoAprendizaje, Long>{

	@Query(value = "select * from resultados_aprendizaje ra where ra.id_programa = :idPrograma and ra.estado = true", nativeQuery = true)
	public Optional<List<ResultadoAprendizaje>> findResultadoAprendizajePrograma(
			@Param("idPrograma") Long idPrograma);
}
