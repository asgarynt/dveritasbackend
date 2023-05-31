package com.dveritas.controller;

import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dveritas.model.Comentario;
import com.dveritas.model.Publicacion;
import com.dveritas.model.Usuario;
import com.dveritas.service.ComentarioService;

@RestController

@RequestMapping(path = "/dveritas/comentarios/") 

public class ComentarioController {

	private final ComentarioService comentarioService;
	
	public ComentarioController (ComentarioService comentarioService) {
		this.comentarioService = comentarioService;
	}
	
	@GetMapping
	public List<Comentario> getComentario(){
		return comentarioService.leerComentarios();
	}
	
	@GetMapping(path="{id}")
	public Comentario getComentario(@PathVariable("id")Long id) {
		return comentarioService.leerComentario(id);
	}

	@PostMapping
	public void postComentario(@RequestBody Comentario comentario) { 

		comentarioService.crearComentario(comentario); 
	}
	
	
	 @GetMapping(path = "/publicaciones/{id}/cantidad")
	    public ResponseEntity<Long> totalLikes(@PathVariable Long id) {
	        Long cantidadComentarios = comentarioService.totalComentarios(id);
	        return ResponseEntity.ok(cantidadComentarios);
	    }
	    
	
	
	
}

