package com.dveritas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


import com.dveritas.model.Like;

import com.dveritas.service.LikeService;


@RestController
@RequestMapping(path = "/dveritas/likes/")
public class LikeController {

    @Autowired
    private LikeService likeService;

    @GetMapping
	public List<Like> getLike(){
		return likeService.leerLikes();
	}
	
	@GetMapping(path="{id}")
	public Like getLike(@PathVariable("id")Long id) {
		return likeService.leerLike(id);
	}
    
		
	
    @GetMapping(path = "/publicaciones/{id}/cantidad")
    public ResponseEntity<Long> totalLikes(@PathVariable Long id) {
        Long cantidadLikes = likeService.totalLikes(id);
        return ResponseEntity.ok(cantidadLikes);
    }
    
    @PostMapping("/{idUsuario}/{idPublicacion}/post")
    public void postLike(@PathVariable Long idUsuario, @PathVariable Long idPublicacion) {
            likeService.agregarLike(idUsuario, idPublicacion);
    }

    
    @DeleteMapping("/{idUsuario}/{idPublicacion}/delete")
    public void deleteLike(@PathVariable Long idUsuario, @PathVariable Long idPublicacion) {
   
            likeService.eliminarLike(idUsuario, idPublicacion);     
    }
    
    @GetMapping("/{idUsuario}/{idPublicacion}/like")
    public ResponseEntity<Boolean> obtenerEstadoLike(@PathVariable Long idUsuario, @PathVariable Long idPublicacion) {
        try {
            boolean liked = likeService.obtenerEstadoLike(idUsuario, idPublicacion);
            return ResponseEntity.ok().body(liked);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(false);
        }
    }
    
}