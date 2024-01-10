package com.unisangil.resultados.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "roles")
@Data
@NoArgsConstructor
public class Rol {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column(name = "nombre", length = 50)
	private String nombre;
	
    @Column(name = "descripcion", length = 250)
	private String descripcion;
    
    @Column(name = "codigo", length = 10)
	private String codigo;
    
    @ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "menu_rol", joinColumns = @JoinColumn(name = "id_rol"), inverseJoinColumns = @JoinColumn(name = "id_menu"))
	private List<Menu> menu = new ArrayList<Menu>();
	
}
