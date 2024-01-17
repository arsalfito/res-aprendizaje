package com.unisangil.resultados.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "criterios_evaluacion_asignatura")
@Data
@NoArgsConstructor
public class CriteriosEvaluacionAsignatura implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
    @Column(name = "estado")
    private Boolean estado;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_resultado_aprendizaje", nullable = false)
    private ResultadoAprendizaje resultadoAprendizaje;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_asignatura", nullable = false)
    private Asignatura asignatura;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_criterio_evaluacion", nullable = false)
    private CriteriosEvaluacion criteriosEvaluacion;
    
    public CriteriosEvaluacionAsignatura(Long id) {
    	this.id = id;
    }
    
}
