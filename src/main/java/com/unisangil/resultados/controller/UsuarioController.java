package com.unisangil.resultados.controller;

import com.unisangil.resultados.model.Usuario;
import com.unisangil.resultados.service.ServiciosUsuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario/v1")
@CrossOrigin(maxAge = 900)
public class UsuarioController extends ControladorBase<Usuario, Long> {
	
	@Autowired
	private ServiciosUsuario serviciosUsuario;

	
}
