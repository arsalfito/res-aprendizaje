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
@Table(name = "parametros")
@Data
@NoArgsConstructor
public class Parametro implements Serializable{
	
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
    
    @Column(name = "orden")
    private Integer orden;
    
    @ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_tipo_parametro")
    private TipoParametro parTipoParametro;

}
