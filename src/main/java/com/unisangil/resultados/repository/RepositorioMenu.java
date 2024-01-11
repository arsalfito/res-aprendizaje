package com.unisangil.resultados.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unisangil.resultados.model.Menu;

@Repository
public interface RepositorioMenu extends JpaRepository<Menu, Long>{

}
