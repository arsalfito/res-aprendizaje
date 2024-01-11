package com.unisangil.resultados.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unisangil.resultados.model.Grupo;

@Repository
public interface RepositorioGrupo extends JpaRepository<Grupo, Long>{

}
