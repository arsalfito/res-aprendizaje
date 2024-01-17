package com.unisangil.resultados.service.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.unisangil.resultados.util.MessageUtil;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EstudianteGrupoDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@NotNull(message = MessageUtil.CALIFICACIONES_EST_GRUP)
	private Long idEstudianteGrupo;
	@NotNull(message = MessageUtil.CALIFICACIONES_CRIT_EV_ASI)
	private Long idCriterioEvaluacionAsignatura;
    private Long idCalificacion;
    private Long idEstudiante;
    private Long idGrupo;
    private String codigo;
    private String nombre;
    private Double calificacion;
	private Double definitiva;
}
