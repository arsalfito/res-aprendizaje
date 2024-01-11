package com.unisangil.resultados.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "escalas_cualitativas")
@Data
@NoArgsConstructor
public class EscalaCualitativa implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
    @Column(name = "escala", length = 30)
    private String escala;
    
    @Column(name = "intervalo_inferior", precision = 2, scale = 1)
    private Double intervaloInferior;
    
    @Column(name = "intervalo_superior", precision = 2, scale = 1)
    private Double intervaloSuperior;
    
    @Column(name = "descripcion", length = 500)
    private String descripcion;
    
    @Column(name = "estado")
    private Boolean estado;

}
