package com.unisangil.resultados.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unisangil.resultados.model.Asignatura;

@Repository
public interface RepositorioAsignatura extends JpaRepository<Asignatura, Long>{

	@Query(value = "select * from asignaturas a join grupos g on a.id = g.id_asignatura join profesores p on g.id_profesor  = "
			+ "p.id where p.documento = :documento and a.id_programa = :idPrograma", nativeQuery = true)
	public Optional<List<Asignatura>> findAsignaturasProfesorPrograma(
			@Param("documento") String documento, @Param("idPrograma") Long idPrograma);
}
