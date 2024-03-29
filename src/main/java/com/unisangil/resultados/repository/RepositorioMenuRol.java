package com.unisangil.resultados.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unisangil.resultados.model.MenuRol;

@Repository
public interface RepositorioMenuRol extends JpaRepository<MenuRol, Long>{

}
