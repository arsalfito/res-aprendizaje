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
@Table(name = "profesores")
@Data
@NoArgsConstructor
public class Profesor implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
    @Column(name = "documento", length = 20)
    private String documento;
    
    @Column(name = "nombre", length = 150)
    private String nombre;
    
    @Column(name = "correo", length = 100)
    private String correo;
    
    @Column(name = "estado")
    private Boolean estado;


}
