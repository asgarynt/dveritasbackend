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

@Table(name="publicaciones")

public class Publicacion {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name = "id", unique = true, nullable = false)
	
	private Long id;
	private String descripcion;
	private String imagen;
	private String fecha_publicacion;
	
	@OneToMany(mappedBy = "publicacion")
	private List<Like> likes;
	
	
	public Publicacion() {
	
	}
	
	
	public Publicacion(Long id, String descripcion, String imagen, String fecha_publicacion) {
		this.id = id;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.fecha_publicacion = fecha_publicacion;
	
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getImagen() {
		return imagen;
	}


	public void setImagen(String imagen) {
		this.imagen = imagen;
	}


	public String getFechaPublicacion() {
		return fecha_publicacion;
	}


	public void setFechaPublicacion(String fecha_publicacion) {
		this.fecha_publicacion = fecha_publicacion;
	}

	

	
	public String getFecha_publicacion() {
		return fecha_publicacion;
	}


	public void setFecha_publicacion(String fecha_publicacion) {
		this.fecha_publicacion = fecha_publicacion;
	}


	


	@Override
	public String toString() {
		return "Publicacion [id=" + id + ", descripcion=" + descripcion + ", imagen=" + imagen + ", likes=" + likes
				+ ", fecha_publicacion=" + fecha_publicacion + "]";
	}
}
