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
@Table(name = "resultados_aprendizaje")
@Data
@NoArgsConstructor
public class ResultadoAprendizaje implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    @Column(name = "codigo", length = 10)
    private String codigo;
    
    @Column(name = "resultado", length = 500)
    private String resultado;
    
    @Column(name = "estado")
    private Boolean estado;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_programa", nullable = false)
    private Programa programa;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_dimension", nullable = false)
    private Parametro dimension;
}
