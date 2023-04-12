package com.dveritas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity 

@Table(name="comentarios")


public class Comentario {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name = "id", unique = true, nullable = false)
	
	
	
	private Long id;
	private String descripcion;
	
	@ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_publicacion", referencedColumnName = "id")
    private Publicacion publicacion;
	
	
	public Comentario() {
	
	}
	
	public Comentario(Long id, String descripcion) {
		this.id = id;
		this.descripcion = descripcion;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Publicacion getPublicacion() {
		return publicacion;
	}

	public void setPublicacion(Publicacion publicacion) {
		this.publicacion = publicacion;
	}

	@Override
	public String toString() {
		return "Comentario [id=" + id + ", descripcion=" + descripcion + "]";
	}
	
	
	
}
