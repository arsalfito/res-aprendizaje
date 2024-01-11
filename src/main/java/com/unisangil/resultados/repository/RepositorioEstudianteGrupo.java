package com.unisangil.resultados.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unisangil.resultados.model.EstudianteGrupo;

@Repository
public interface RepositorioEstudianteGrupo extends JpaRepository<EstudianteGrupo, Long>{

}
