package com.unisangil.resultados.service.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResultadoAprendizajeDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Long id;
    private String codigo;
    private String resultado;
    private Boolean estado;
    private Long idPrograma;
    private Long idDimension;
    private String dimension;
}
