package com.dveritas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 

@Table(name="contactos")

public class Contacto {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name = "id", unique = true, nullable = false)
	
	private Long id;
	private String nombre;
	private String correo;
	private String asunto;
	private String comentario;
	
	
	public Contacto() {
			}
	
	
	
	
	public Contacto(Long id, String nombre, String correo, String asunto, String comentario) {
		this.id = id;
		this.nombre = nombre;
		this.correo = correo;
		this.asunto = asunto;
		this.comentario = comentario;
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




	public String getAsunto() {
		return asunto;
	}




	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}




	public String getComentario() {
		return comentario;
	}




	public void setComentario(String comentario) {
		this.comentario = comentario;
	}




	@Override
	public String toString() {
		return "Contacto [id=" + id + ", nombre=" + nombre + ", correo=" + correo + ", asunto=" + asunto
				+ ", comentario=" + comentario + "]";
	}
	
	
	
	
	
}
