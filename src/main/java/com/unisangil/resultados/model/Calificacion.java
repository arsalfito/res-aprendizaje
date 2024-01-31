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
@Table(name = "calificaciones")
@Data
@NoArgsConstructor
public class Calificacion implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
    @Column(name = "calificacion", precision = 2, scale = 1)
    private Double calificacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_crit_eval_asign", nullable = false)
    private CriteriosEvaluacionAsignatura criteriosEvaluacionAsignatura;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estud_grupo", nullable = false)
    private EstudianteGrupo estudianteGrupo;
    
    
}
