package com.unisangil.resultados.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name = "documento", length = 20, unique = true)
	private String documento;
    
    @Column(name = "nombre", length = 100)
    private String nombre;
    
    @Column(name = "password", length = 50)
    private String password;
    
    @Column(name = "email", length = 100)
    private String email;
    
    @ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "usuarios_rol", joinColumns = @JoinColumn(name = "id_usuario"), inverseJoinColumns = @JoinColumn(name = "id_rol"))
	private List<Rol> roles = new ArrayList<Rol>();

}

