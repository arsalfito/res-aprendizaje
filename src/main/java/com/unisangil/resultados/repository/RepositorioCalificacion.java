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
	
	@Query(value = "select count(*) from calificaciones c join estudiantes_grupo eg on c.id_estud_grupo = eg.id "
			+ "where c.id_crit_eval_asign = :idCritEvaAsig and eg.id_grupo = :idGrupo and c.calificacion is not null", nativeQuery = true)
	public Optional<Long> getNumeroCalificacionesByGrupoCriterio(
			@Param("idCritEvaAsig") Long idCritEvaAsig, 
			@Param("idGrupo") Long idGrupo);
	
	@Query(value = "select * from calificaciones c where c.id_estud_grupo = :idEstudGrupo", nativeQuery = true)
	public Optional<List<Calificacion>> findCalificacionByIdEstudianteGrupo(@Param("idEstudGrupo") Long idEstudGrupo);
	
	@Query(value = "select c.id_estud_grupo, avg(c.calificacion) as nota_promedio "
			+ "from calificaciones c join estudiantes_grupo eg on c.id_estud_grupo = eg.id "
			+ "join grupos g on eg.id_grupo = g.id "
			+ "where g.id = :idGrupo "
			+ "group by c.id_estud_grupo", nativeQuery = true)
	Optional<List<Object[]>> calcularPromedioGrupo(@Param("idGrupo") Long idGrupo);
}
