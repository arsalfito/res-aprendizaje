package com.unisangil.resultados.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unisangil.resultados.model.Usuario;

@Repository
public interface RepositorioUsuario extends JpaRepository<Usuario, Long>{

	@Query(value = "select * from usuarios u where nombre = :userName and password = :password", nativeQuery = true)
	public Optional<Usuario> getByUserName(@Param("userName") String userName, @Param("password") String password);
}
