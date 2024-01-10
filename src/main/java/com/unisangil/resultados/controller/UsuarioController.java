package com.unisangil.resultados.controller;

import com.unisangil.resultados.controller.dto.LoginDTO;
import com.unisangil.resultados.controller.dto.ResponseDetailLoginDTO;
import com.unisangil.resultados.model.Usuario;
import com.unisangil.resultados.service.ServiciosUsuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario/v1")
@CrossOrigin(maxAge = 900)
public class UsuarioController extends ControladorBase<Usuario, Long> {
	
	@Autowired
	private ServiciosUsuario serviciosUsuario;

	@PostMapping("/login/")
    public ResponseEntity<ResponseDetailLoginDTO> login(@RequestBody LoginDTO dto){
        ResponseDetailLoginDTO data = this.serviciosUsuario.login(dto);
        return new ResponseEntity<ResponseDetailLoginDTO>(data, (data == null || !data.isSuccess() ? HttpStatus.UNAUTHORIZED : HttpStatus.OK));
    }
	
}
