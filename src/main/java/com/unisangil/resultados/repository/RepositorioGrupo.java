package com.unisangil.resultados.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unisangil.resultados.model.Grupo;

@Repository
public interface RepositorioGrupo extends JpaRepository<Grupo, Long>{
	
	@Query(value = "select * from grupos g where g.id_asignatura = :idAsignatura and g.cerrado = :cerrado", nativeQuery = true)
	public Optional<List<Grupo>> findGruposByAsignatura(
			@Param("idAsignatura") Long idAsignatura, @Param("cerrado") Boolean cerrado);

}
