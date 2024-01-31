package com.unisangil.resultados.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unisangil.resultados.model.EstudianteGrupo;

@Repository
public interface RepositorioEstudianteGrupo extends JpaRepository<EstudianteGrupo, Long>{
	
	@Query(value = "select * from estudiantes_grupo eg where eg.id_grupo = :idGrupo", nativeQuery = true)
	public Optional<List<EstudianteGrupo>> findEstudianteGrupoByGrupo(@Param("idGrupo") Long idGrupo);

}
