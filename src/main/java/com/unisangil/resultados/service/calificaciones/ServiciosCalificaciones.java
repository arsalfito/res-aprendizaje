package com.unisangil.resultados.service.calificaciones;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unisangil.resultados.controller.dto.ResponseDTO;
import com.unisangil.resultados.model.Asignatura;
import com.unisangil.resultados.model.Calificacion;
import com.unisangil.resultados.model.CriteriosEvaluacion;
import com.unisangil.resultados.model.CriteriosEvaluacionAsignatura;
import com.unisangil.resultados.model.EstudianteGrupo;
import com.unisangil.resultados.model.Grupo;
import com.unisangil.resultados.model.ResultadoAprendizaje;
import com.unisangil.resultados.repository.RepositorioAsignatura;
import com.unisangil.resultados.repository.RepositorioCalificacion;
import com.unisangil.resultados.repository.RepositorioCriteriosEvaluacion;
import com.unisangil.resultados.repository.RepositorioCriteriosEvaluacionAsignatura;
import com.unisangil.resultados.repository.RepositorioEstudianteGrupo;
import com.unisangil.resultados.repository.RepositorioGrupo;
import com.unisangil.resultados.repository.RepositorioPrograma;
import com.unisangil.resultados.repository.RepositorioResultadoAprendizaje;
import com.unisangil.resultados.service.dto.AsignaturaDTO;
import com.unisangil.resultados.service.dto.CriteriosEvaluacionAsignaturaDTO;
import com.unisangil.resultados.service.dto.CriteriosEvaluacionDTO;
import com.unisangil.resultados.service.dto.EstudianteGrupoDTO;
import com.unisangil.resultados.service.dto.GrupoDTO;
import com.unisangil.resultados.service.dto.ProgramaDTO;
import com.unisangil.resultados.service.dto.ResultadoAprendizajeDTO;
import com.unisangil.resultados.service.helper.ParametrosHelper;
import com.unisangil.resultados.service.helper.ResultadoAprendizajeHelper;
import com.unisangil.resultados.util.MessageUtil;

@Service
public class ServiciosCalificaciones {

	@Autowired
	private RepositorioPrograma repositorioPrograma;
	
	@Autowired
	private RepositorioAsignatura repositorioAsignatura;
	
	@Autowired
	private RepositorioGrupo repositorioGrupo;
	
	@Autowired
	private RepositorioResultadoAprendizaje repositorioResultadoAprendizaje;
	
	@Autowired
	private RepositorioCriteriosEvaluacion repositorioCriteriosEvaluacion;
	
	@Autowired
	private RepositorioCriteriosEvaluacionAsignatura repositorioCriteriosEvaluacionAsignatura;
	
	@Autowired
	private RepositorioEstudianteGrupo repositorioEstudianteGrupo;
	
	@Autowired
	private RepositorioCalificacion repositorioCalificacion;
	
	public List<ProgramaDTO> findAllProgramas(){
		return ParametrosHelper.toDTOProgramas(this.repositorioPrograma.findAll()) ;
	}
	
	public List<AsignaturaDTO> findAsignaturasProfesor(String documento, Long idPrograma){
		Optional<List<Asignatura>> optAsignaturas = this.repositorioAsignatura.findAsignaturasProfesorPrograma(documento, idPrograma);
		if(optAsignaturas.isPresent() && !optAsignaturas.isEmpty()){
			return ParametrosHelper.toDTOAsignaturas(optAsignaturas.get());
		}else
			return null;
	}
	
	public List<GrupoDTO> findGruposByAsignatura(Long idAsignatura, Boolean cerrado){
		Optional<List<Grupo>> optGrupos = this.repositorioGrupo.findGruposByAsignatura(idAsignatura, cerrado);
		if(optGrupos.isPresent() && !optGrupos.isEmpty()){
			return ParametrosHelper.toDTOGrupos(optGrupos.get());
		}else
			return null;
	}
	
	public List<ResultadoAprendizajeDTO> findResultadoAprendizajePrograma(Long idPrograma){
		Optional<List<ResultadoAprendizaje>> optResAprendizaje = this.repositorioResultadoAprendizaje.findResultadoAprendizajePrograma(idPrograma);
		if(optResAprendizaje.isPresent() && !optResAprendizaje.isEmpty()){
			return ResultadoAprendizajeHelper.toDTOResultadosAprendizaje(optResAprendizaje.get());
		}else
			return null;
	}
	
	public List<CriteriosEvaluacionDTO> findCriteriosEvaluacionPrograma(Long idPrograma){
		Optional<List<CriteriosEvaluacion>> optCriteEvalua = this.repositorioCriteriosEvaluacion.findCriteriosEvaluacionPrograma(idPrograma);
		if(optCriteEvalua.isPresent() && !optCriteEvalua.isEmpty()){
			return ResultadoAprendizajeHelper.toDTOCriteriosEvaluacion(optCriteEvalua.get());
		}else
			return null;
	}
	
	public List<CriteriosEvaluacionAsignaturaDTO> findCriteriosEvaluacionAsignatura(
			Long idAsignatura, Long idResultadoAprend){
		Optional<List<CriteriosEvaluacionAsignatura>> optCriteEvaluaAsig = this.repositorioCriteriosEvaluacionAsignatura.findCriteriosEvaluacionAsignatura(
				idAsignatura, idResultadoAprend);
		if(optCriteEvaluaAsig.isPresent() && !optCriteEvaluaAsig.isEmpty()){
			return ResultadoAprendizajeHelper.toDTOCriteriosEvaluacionAsignatura(optCriteEvaluaAsig.get());
		}else
			return null;
	}
	
	public  List<EstudianteGrupoDTO> findEstudiantesByGrupoCriterioEvaluacion(Long idGrupo, Long idResultado, Long idCriterioEvaluacion ){
		
		Optional<List<EstudianteGrupo>> opt = this.repositorioEstudianteGrupo.findEstudianteGrupoByGrupo(idGrupo);
		if(!opt.isPresent())
			return null;
		List<EstudianteGrupoDTO> estudiantesGrupoDTO = ResultadoAprendizajeHelper.toDTOEstudianteGrupo(opt.get());
		
		Optional<Grupo>	 optGrupo = this.repositorioGrupo.findById(idGrupo);
		if(!optGrupo.isPresent()) return null;		
		Long idAsignatura = optGrupo.get().getAsignatura() != null ? optGrupo.get().getAsignatura().getId() : null;
		
		Optional<CriteriosEvaluacionAsignatura> optCriterio = this.repositorioCriteriosEvaluacionAsignatura
				.findCriteriosEvaluacionAsignaturaResultadoCriterio(idAsignatura, idResultado, idCriterioEvaluacion);
		if(!optCriterio.isPresent()) return null;
		
		Optional<List<Calificacion>> optCalificaciones = this.repositorioCalificacion
				.findCalificacionByGrupoCriterio(optCriterio.get().getId(), idGrupo);
		
		if(optCalificaciones.isPresent() && optCalificaciones.isEmpty())
			return estudiantesGrupoDTO;
		
		List<Calificacion> calificaciones = optCalificaciones.get(); 
		for(EstudianteGrupoDTO e: estudiantesGrupoDTO) {
			
			Optional<Calificacion> cal = calificaciones.stream()
					.filter(calificacion -> calificacion.getEstudianteGrupo().getId().equals(e.getIdEstudianteGrupo()))
					.findFirst();
			if(cal.isPresent()){
				e.setIdCalificacion(cal.get().getId());
				e.setCalificacion(cal.get().getCalificacion());
				e.setIdCriterioEvaluacionAsignatura(cal.get().getCriteriosEvaluacionAsignatura() != null ? 
						cal.get().getCriteriosEvaluacionAsignatura().getId() : null);
			}			
		}
		
		return estudiantesGrupoDTO;
	}
	
	public ResponseDTO registrarCalificaciones(List<EstudianteGrupoDTO> estudiantes) {
		ResponseDTO response = new ResponseDTO();
		try {
			if(estudiantes == null || estudiantes.isEmpty()) {
				response.setSuccess(false);
				response.setMessage(MessageUtil.CALIFICACIONES_NULL);
				return response;			
			}
			
			List<Calificacion> calificaciones = new ArrayList<>();
			for(EstudianteGrupoDTO e: estudiantes) {
				Calificacion cal = new Calificacion();
				cal.setId(e.getIdCalificacion());
				cal.setCalificacion(e.getCalificacion());
				cal.setEstudianteGrupo(e.getIdEstudianteGrupo() != null ? 
						new EstudianteGrupo(e.getIdEstudianteGrupo()): null);
				cal.setCriteriosEvaluacionAsignatura(e.getIdCriterioEvaluacionAsignatura() != null ? 
						new CriteriosEvaluacionAsignatura(e.getIdCriterioEvaluacionAsignatura()): null);
				calificaciones.add(cal);
			}
						
			repositorioCalificacion.saveAll(calificaciones);
			response.setSuccess(true);
			response.setMessage(MessageUtil.CALIFICACIONES_OK);
		}catch (Exception e) {
			
		}
		return response;
	}
	
}
