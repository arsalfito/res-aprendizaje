package com.unisangil.resultados.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unisangil.resultados.model.Profesor;


@Repository
public interface RepositorioProfesor extends JpaRepository<Profesor, Long>{

}
