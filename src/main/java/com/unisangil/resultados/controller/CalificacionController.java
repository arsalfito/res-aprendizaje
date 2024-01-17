package com.unisangil.resultados.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unisangil.resultados.controller.dto.ResponseDTO;
import com.unisangil.resultados.service.calificaciones.ServiciosCalificaciones;
import com.unisangil.resultados.service.dto.AsignaturaDTO;
import com.unisangil.resultados.service.dto.CriteriosEvaluacionAsignaturaDTO;
import com.unisangil.resultados.service.dto.CriteriosEvaluacionDTO;
import com.unisangil.resultados.service.dto.EstudianteGrupoDTO;
import com.unisangil.resultados.service.dto.GrupoDTO;
import com.unisangil.resultados.service.dto.ProgramaDTO;
import com.unisangil.resultados.service.dto.ResultadoAprendizajeDTO;

@RestController
@RequestMapping("/calificacion/v1")
@CrossOrigin(maxAge = 900)
@Validated
public class CalificacionController {
	
	@Autowired
	private ServiciosCalificaciones serviciosCalificaciones;
	
	@GetMapping("/find-all-programas")
	public ResponseEntity<List<ProgramaDTO>>findAllProgramas(){
		List<ProgramaDTO> data = this.serviciosCalificaciones.findAllProgramas();
		return new ResponseEntity<List<ProgramaDTO>>(data,
                (data == null ? HttpStatus.NOT_FOUND : HttpStatus.OK));
	}
	
	@GetMapping("/find-asignaturas-profesor/{docu}/{idProg}")
	public ResponseEntity<List<AsignaturaDTO>> findAsignaturasProfesor(
			@PathVariable("docu") String documento, @PathVariable("idProg")  Long idPrograma){
		List<AsignaturaDTO> data = this.serviciosCalificaciones.findAsignaturasProfesor(documento, idPrograma);
		return new ResponseEntity<List<AsignaturaDTO>>(data,
                (data == null ? HttpStatus.NOT_FOUND : HttpStatus.OK));
	}
	
	@GetMapping("/find-grupos-asignatura/{idAsig}/{cerrado}")
	public ResponseEntity<List<GrupoDTO>> findGruposByAsignatura(
			@PathVariable("idAsig") Long idAsignatura, @PathVariable("cerrado") Boolean cerrado){
		List<GrupoDTO> data = this.serviciosCalificaciones.findGruposByAsignatura(idAsignatura, cerrado);
		return new ResponseEntity<List<GrupoDTO>>(data,
                (data == null ? HttpStatus.NOT_FOUND : HttpStatus.OK));
	}
	
	@GetMapping("/find-resultado-aprendizaje-programa/{idProg}")
	public ResponseEntity<List<ResultadoAprendizajeDTO>> findResultadoAprendizajePrograma(
			@PathVariable("idProg") Long idPrograma){
		List<ResultadoAprendizajeDTO> data = this.serviciosCalificaciones.findResultadoAprendizajePrograma(idPrograma);
		return new ResponseEntity<List<ResultadoAprendizajeDTO>>(data,
                (data == null ? HttpStatus.NOT_FOUND : HttpStatus.OK));
	}
	
	@GetMapping("/find-criterios-evaluacion-programa/{idProg}")
	public ResponseEntity<List<CriteriosEvaluacionDTO>> findCriteriosEvaluacionPrograma(
			@PathVariable("idProg") Long idPrograma){
		List<CriteriosEvaluacionDTO> data = this.serviciosCalificaciones.findCriteriosEvaluacionPrograma(idPrograma);
		return new ResponseEntity<List<CriteriosEvaluacionDTO>>(data,
                (data == null ? HttpStatus.NOT_FOUND : HttpStatus.OK));
	}
	
	@GetMapping("/find-criterios-evaluacion-asignatura/{idAsig}/{idResApr}")
	public ResponseEntity<List<CriteriosEvaluacionAsignaturaDTO>> findCriteriosEvaluacionAsignatura(
			@PathVariable("idAsig") Long idAsignatura, @PathVariable("idResApr") Long idResultadoAprend){
		List<CriteriosEvaluacionAsignaturaDTO> data = 
				this.serviciosCalificaciones.findCriteriosEvaluacionAsignatura(idAsignatura, idResultadoAprend);
		return new ResponseEntity<List<CriteriosEvaluacionAsignaturaDTO>>(data,
                (data == null ? HttpStatus.NOT_FOUND : HttpStatus.OK));
	}
	
	@GetMapping("/find-estudiantes-grupo-criterio-evaluacion/{idGrupo}/{idResultado}/{idCriterio}")
	public ResponseEntity<List<EstudianteGrupoDTO>> findEstudiantesByGrupoCriterioEvaluacion(
			@PathVariable("idGrupo") Long idGrupo, 
			@PathVariable("idResultado") Long idResultado, 
			@PathVariable("idCriterio") Long idCriterio){
		List<EstudianteGrupoDTO> data = 
				this.serviciosCalificaciones.findEstudiantesByGrupoCriterioEvaluacion(idGrupo, idResultado, idCriterio);
		return new ResponseEntity<List<EstudianteGrupoDTO>>(data,
                (data == null ? HttpStatus.NOT_FOUND : HttpStatus.OK));
	}
	
	@PostMapping("registrar-calificaciones")
	public ResponseEntity<ResponseDTO> registrarCalificaciones(@Valid @RequestBody List<EstudianteGrupoDTO> dto){
		ResponseDTO data = this.serviciosCalificaciones.registrarCalificaciones(dto);
		return new ResponseEntity<ResponseDTO>(data,
                (data == null || !data.isSuccess() ? HttpStatus.NOT_ACCEPTABLE : HttpStatus.OK));
	}
			

}
