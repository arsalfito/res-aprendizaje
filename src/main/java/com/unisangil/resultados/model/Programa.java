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
@Table(name = "programas")
@Data
@NoArgsConstructor
public class Programa implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
    @Column(name = "nombre", length = 50)
    private String nombre;
    
    @Column(name = "perfil", length = 500)
    private String perfil;

}
