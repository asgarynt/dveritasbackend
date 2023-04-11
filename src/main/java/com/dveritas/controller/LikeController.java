package com.dveritas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


import com.dveritas.model.Like;

import com.dveritas.service.LikeService;

@CrossOrigin

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
    
    
    
    
}