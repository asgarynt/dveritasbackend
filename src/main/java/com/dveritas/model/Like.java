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

@Table(name="likes")


public class Like {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name = "id", unique = true, nullable = false)
	 private Long id;

	  	@ManyToOne
	    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
	    private Usuario usuario;
	
	    @ManyToOne
	    @JoinColumn(name = "id_publicacion", referencedColumnName = "id")
	    private Publicacion publicacion;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
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
	    

		
		
	    
}


