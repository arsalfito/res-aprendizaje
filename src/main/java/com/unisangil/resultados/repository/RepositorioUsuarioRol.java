package com.unisangil.resultados.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unisangil.resultados.model.UsuarioRol;

@Repository
public interface RepositorioUsuarioRol extends JpaRepository<UsuarioRol, Long>{

}
