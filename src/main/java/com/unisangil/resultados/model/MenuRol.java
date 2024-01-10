package com.unisangil.resultados.model;

import java.io.Serializable;

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
@Table(name = "menu_rol")
@Data
@NoArgsConstructor
public class MenuRol implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMenuRol;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_rol")
	private Rol rol;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_menu")
	private Menu menu;
}
