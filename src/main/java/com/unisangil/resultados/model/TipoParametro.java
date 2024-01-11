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
@Table(name = "tipo_parametro")
@Data
@NoArgsConstructor
public class TipoParametro implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
	@Column(name = "nombre", length = 50)
	private String nombre;
    
	@Column(name = "descripcion", length = 250)
	private String descripcion;
    
	@Column(name = "codigo", length = 10)
	private String codigo;
    
	@Column(name = "estado")
    private Boolean estado;

}
