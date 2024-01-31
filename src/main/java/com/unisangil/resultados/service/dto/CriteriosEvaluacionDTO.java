package com.unisangil.resultados.service.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CriteriosEvaluacionDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
    private String codigo;
    private String criterio;
    private Boolean estado;
    private Long idPrograma;

}
