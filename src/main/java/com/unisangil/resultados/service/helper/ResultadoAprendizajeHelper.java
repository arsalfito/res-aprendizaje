package com.unisangil.resultados.service.helper;

import java.util.List;
import java.util.stream.Collectors;

import com.unisangil.resultados.model.CriteriosEvaluacion;
import com.unisangil.resultados.model.CriteriosEvaluacionAsignatura;
import com.unisangil.resultados.model.EstudianteGrupo;
import com.unisangil.resultados.model.ResultadoAprendizaje;
import com.unisangil.resultados.service.dto.CriteriosEvaluacionAsignaturaDTO;
import com.unisangil.resultados.service.dto.CriteriosEvaluacionDTO;
import com.unisangil.resultados.service.dto.EstudianteGrupoDTO;
import com.unisangil.resultados.service.dto.ResultadoAprendizajeDTO;

public class ResultadoAprendizajeHelper {

	public static ResultadoAprendizajeDTO getResultadoAprendizajeDTO(ResultadoAprendizaje entity) {
		ResultadoAprendizajeDTO dto = new ResultadoAprendizajeDTO();
		dto.setId(entity.getId());
		dto.setCodigo(entity.getCodigo());
		dto.setResultado(entity.getResultado());
		dto.setEstado(entity.getEstado());
		dto.setIdPrograma(entity.getPrograma() != null ? entity.getPrograma().getId() : null);
		dto.setIdDimension(entity.getDimension()!= null ? entity.getDimension().getId() : null);
		dto.setDimension(entity.getDimension()!= null ? entity.getDimension().getNombre() : null);
		return dto;
	}
	
	public static List<ResultadoAprendizajeDTO> toDTOResultadosAprendizaje(List<ResultadoAprendizaje> entities) {
        return entities.stream().map(ResultadoAprendizajeHelper::getResultadoAprendizajeDTO).collect(Collectors.toList());
    }
	
	public static CriteriosEvaluacionDTO getCriteriosEvaluacionDTO(CriteriosEvaluacion entity) {
		CriteriosEvaluacionDTO dto = new CriteriosEvaluacionDTO();
		dto.setId(entity.getId());
		dto.setCodigo(entity.getCodigo());
		dto.setCriterio(entity.getCriterio());
		dto.setEstado(entity.getEstado());
		dto.setIdPrograma(entity.getPrograma() != null ? entity.getPrograma().getId() : null);
		
		return dto;
	}
	
	public static List<CriteriosEvaluacionDTO> toDTOCriteriosEvaluacion(List<CriteriosEvaluacion> entities) {
        return entities.stream().map(ResultadoAprendizajeHelper::getCriteriosEvaluacionDTO).collect(Collectors.toList());
    }
	
	public static CriteriosEvaluacionAsignaturaDTO getCriteriosEvaluacionAsignaturaDTO(CriteriosEvaluacionAsignatura entity) {
		CriteriosEvaluacionAsignaturaDTO dto = new CriteriosEvaluacionAsignaturaDTO();
		dto.setId(entity.getId());
		dto.setEstado(entity.getEstado());
		dto.setResultadoAprendizajeDTO(entity.getResultadoAprendizaje() != null ? 
				getResultadoAprendizajeDTO(entity.getResultadoAprendizaje()) : null);
		dto.setIdAsignatura(entity.getAsignatura() != null ? entity.getAsignatura().getId() : null);
		dto.setCriteriosEvaluacionDTO(entity.getCriteriosEvaluacion() != null ? 
				getCriteriosEvaluacionDTO(entity.getCriteriosEvaluacion()) : null);
		
		return dto;
	}
	
	public static List<CriteriosEvaluacionAsignaturaDTO> toDTOCriteriosEvaluacionAsignatura(List<CriteriosEvaluacionAsignatura> entities) {
        return entities.stream().map(ResultadoAprendizajeHelper::getCriteriosEvaluacionAsignaturaDTO).collect(Collectors.toList());
    }
	
	public static EstudianteGrupoDTO getEstudianteGrupo(EstudianteGrupo entity) {
		EstudianteGrupoDTO dto = new EstudianteGrupoDTO();
		dto.setIdEstudianteGrupo(entity.getId());
		dto.setIdEstudiante(entity.getEstudiante() != null ? entity.getEstudiante().getId() : null);
		dto.setIdGrupo(entity.getGrupo() != null ? entity.getGrupo().getId() : null);
		dto.setCodigo(entity.getEstudiante() != null ? entity.getEstudiante().getCodigo() : null);
		dto.setNombre(entity.getEstudiante() != null ? entity.getEstudiante().getNombre() : null);
		dto.setDefinitiva(entity.getDefinitiva());
		
		return dto;
		
 	}
	
	public static List<EstudianteGrupoDTO> toDTOEstudianteGrupo(List<EstudianteGrupo> entities) {
        return entities.stream().map(ResultadoAprendizajeHelper::getEstudianteGrupo).collect(Collectors.toList());
    }
}
