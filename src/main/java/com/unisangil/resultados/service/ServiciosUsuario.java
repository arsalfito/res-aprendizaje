package com.unisangil.resultados.service;

import com.unisangil.resultados.model.Usuario;
import com.unisangil.resultados.repository.RepositorioUsuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ServiciosUsuario extends ServiciosBase<Usuario, Long>{

	@Autowired
	private RepositorioUsuario repositorioUsuario;
}
