package com.dveritas.service;

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

}