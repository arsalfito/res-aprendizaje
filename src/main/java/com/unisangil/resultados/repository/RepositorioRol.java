package com.unisangil.resultados.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unisangil.resultados.model.Rol;

@Repository
public interface RepositorioRol extends JpaRepository<Rol, Long>{

}
