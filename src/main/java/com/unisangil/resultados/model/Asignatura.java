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
@Table(name = "asignaturas")
@Data
@NoArgsConstructor
public class Asignatura implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
    @Column(name = "codigo", length = 30)
    private String codigo;
    
    @Column(name = "nombre", length = 200)
    private String nombre;
    
    @Column(name = "estado")
    private Boolean estado;

}
