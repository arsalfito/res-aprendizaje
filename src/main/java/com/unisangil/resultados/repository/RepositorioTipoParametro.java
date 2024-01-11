package com.unisangil.resultados.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unisangil.resultados.model.TipoParametro;

@Repository
public interface RepositorioTipoParametro extends JpaRepository<TipoParametro, Long>{

}
