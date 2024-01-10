package com.unisangil.resultados.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unisangil.resultados.model.Usuario;

@Repository
public interface RepositorioUsuario extends JpaRepository<Usuario, Long>{

}
