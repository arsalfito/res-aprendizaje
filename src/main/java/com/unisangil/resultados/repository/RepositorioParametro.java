package com.unisangil.resultados.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unisangil.resultados.model.Parametro;

@Repository
public interface RepositorioParametro extends JpaRepository<Parametro, Long>{

}
