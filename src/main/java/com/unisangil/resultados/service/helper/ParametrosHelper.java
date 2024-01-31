package com.unisangil.resultados.service.helper;

import java.util.List;
import java.util.stream.Collectors;

import com.unisangil.resultados.model.Asignatura;
import com.unisangil.resultados.model.Grupo;
import com.unisangil.resultados.model.Programa;
import com.unisangil.resultados.service.dto.AsignaturaDTO;
import com.unisangil.resultados.service.dto.GrupoDTO;
import com.unisangil.resultados.service.dto.ProgramaDTO;

public class ParametrosHelper {
	
	public static ProgramaDTO getProgramaDTO(Programa entity) {
		ProgramaDTO dto = new ProgramaDTO();
		dto.setId(entity.getId());
		dto.setNombre(entity.getNombre());
		dto.setPerfil(entity.getPerfil());
		
		return dto;
	}

	public static List<ProgramaDTO> toDTOProgramas(List<Programa> entities) {
        return entities.stream().map(ParametrosHelper::getProgramaDTO).collect(Collectors.toList());
    }
	
	public static AsignaturaDTO getAsignaturaDTO(Asignatura entity) {
		AsignaturaDTO dto = new AsignaturaDTO();
		dto.setId(entity.getId());
		dto.setCodigo(entity.getCodigo());
		dto.setNombre(entity.getNombre());
		dto.setEstado(entity.getEstado());
		
		return dto;
	}
	
	public static List<AsignaturaDTO> toDTOAsignaturas(List<Asignatura> entities) {
        return entities.stream().map(ParametrosHelper::getAsignaturaDTO).collect(Collectors.toList());
    }
	
	public static GrupoDTO getGrupoDTO(Grupo entity) {
		GrupoDTO dto = new GrupoDTO();
		
		dto.setId(entity.getId());
		dto.setCodigo(entity.getCodigo());
		dto.setPeriodo(entity.getPeriodo());
		dto.setCerrado(entity.getCerrado());
		dto.setIdAsignatura(entity.getAsignatura() != null ? entity.getAsignatura().getId() : null);
		dto.setIdProfesor(entity.getProfesor() != null ? entity.getProfesor().getId() : null);
		
		return dto;
	}
	
	public static List<GrupoDTO> toDTOGrupos(List<Grupo> entities) {
        return entities.stream().map(ParametrosHelper::getGrupoDTO).collect(Collectors.toList());
    }
	
	
}
