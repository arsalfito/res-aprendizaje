package com.unisangil.resultados.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unisangil.resultados.model.Calificacion;

@Repository
public interface RepositorioCalificacion extends JpaRepository<Calificacion, Long>{

	@Query(value = "select * from calificaciones c "
			+ "join estudiantes_grupo eg on c.id_estud_grupo = eg.id "
			+ "where c.id_crit_eval_asign = :idCritEvaAsig and eg.id_grupo = :idGrupo", nativeQuery = true)
	public Optional<List<Calificacion>> findCalificacionByGrupoCriterio(
			@Param("idCritEvaAsig") Long idCritEvaAsig, 
			@Param("idGrupo") Long idGrupo);
}
