package com.unisangil.resultados.service.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CriteriosEvaluacionAsignaturaDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
    private Boolean estado;
    private Long idAsignatura;
    private ResultadoAprendizajeDTO resultadoAprendizajeDTO;    
    private CriteriosEvaluacionDTO criteriosEvaluacionDTO;

}
