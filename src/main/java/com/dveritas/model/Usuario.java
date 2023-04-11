package com.dveritas.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity

@Table(name="usuarios")


public class Usuario {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name = "id", unique = true, nullable = false)
	
	private Long id;
	private String nombre;
	private String correo;
	private String password;
	private String avatar;
	
	 @OneToMany(mappedBy = "usuario")
	    private List<Like> likes;
	
	
	public Usuario() {
		
	}
	
	public Usuario(Long id, String nombre, String correo, String password, String avatar) {
		this.id = id;
		this.nombre = nombre;
		this.correo = correo;
		this.password = password;
		this.avatar = avatar;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	
	
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", correo=" + correo + ", password=" + password
				+ ", avatar=" + avatar + "]";
	}
}
