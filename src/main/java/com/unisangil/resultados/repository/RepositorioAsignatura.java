package com.unisangil.resultados.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unisangil.resultados.model.Asignatura;

@Repository
public interface RepositorioAsignatura extends JpaRepository<Asignatura, Long>{

}
