package com.dveritas.service;

import com.dveritas.model.Usuario;
import com.dveritas.model.Publicacion;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.dveritas.model.Like;

import com.dveritas.repository.LikeRepository;

@Service
public class LikeService {

    @Autowired
    private LikeRepository likeRepository;

    public List<Like> leerLikes(){
    	
		return likeRepository.findAll(); 	
		
	}
	
	public Like leerLike(Long Id) {
		
		return likeRepository.findById(Id).orElseThrow(()-> new IllegalStateException("La publicacion " + "con el id " + Id + " no existe.") ); 
		
	}
    
	 
	  
    public Long totalLikes(Long publicacionId) {
    	return likeRepository.countByPublicacionId(publicacionId);
    }
    
    public void eliminarLike(Long idUsuario, Long idPublicacion) {
        Like likeExistente = likeRepository.findByUsuarioIdAndPublicacionId(idUsuario, idPublicacion);
        if (likeExistente != null) {
            likeRepository.delete(likeExistente);
        } 
    }
    
    public void agregarLike(Long idUsuario, Long idPublicacion) {
   
            Usuario usuario = new Usuario();
            usuario.setId(idUsuario);
            Publicacion publicacion = new Publicacion();
            publicacion.setId(idPublicacion);
            Like nuevoLike = new Like();
            nuevoLike.setUsuario(usuario);
            nuevoLike.setPublicacion(publicacion);
            likeRepository.save(nuevoLike);
   
    }
    
    public boolean obtenerEstadoLike(Long idUsuario, Long idPublicacion) {
        Like likeExistente = likeRepository.findByUsuarioIdAndPublicacionId(idUsuario, idPublicacion);
        return likeExistente != null;
    }
    

}