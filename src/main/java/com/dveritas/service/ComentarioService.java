package com.dveritas.service;

import com.dveritas.repository.ComentarioRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dveritas.model.Comentario;

@Service

public class ComentarioService {

	
	private final ComentarioRepository comentarioRepository;
	
	
	
	@Autowired
	public ComentarioService (ComentarioRepository comentarioRepository) {
		
		this.comentarioRepository = comentarioRepository;
		
	}
		
	public List<Comentario> leerComentarios(){
	
		return comentarioRepository.findAll(); 	
		
	}
	
	public Comentario leerComentario(Long Id) {
		
		return comentarioRepository.findById(Id).orElseThrow(()-> new IllegalStateException("El Producto " + "con el id " + Id + " no existe.") ); 
		
	} 
	

	public void crearComentario(Comentario comentario) {

			comentarioRepository.save(comentario); 

		}

	 public Long totalComentarios(Long publicacionId) {
	    	return comentarioRepository.countByPublicacionId(publicacionId);
	    }

}





