package com.unisangil.resultados.service.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProgramaDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
    private String nombre;
    private String perfil;

}
