package com.dveritas.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dveritas.model.Publicacion;
import com.dveritas.service.PublicacionService;

@CrossOrigin

@RestController

@RequestMapping(path = "/dveritas/publicaciones/")

public class PublicacionController {

	private final PublicacionService publicacionService;
	

	public PublicacionController (PublicacionService publicacionService) {
		this.publicacionService = publicacionService;
	}
	
	@GetMapping
	public List<Publicacion> getPublicacion(){
		return publicacionService.leerPublicaciones();
	}
	
	@GetMapping(path="{id}")
	public Publicacion getPublicacion(@PathVariable("id")Long id) {
		return publicacionService.leerPublicacion(id);
	}
	
	@PostMapping
	public void postPublicacion(@RequestBody Publicacion publicacion) { 

		publicacionService.crearPublicacion(publicacion); 
	}
	
	@DeleteMapping(path = "{Id}")
	public void deletePublicacion(@PathVariable("Id") Long Id) {
		publicacionService.borrarPublicacion(Id);
	}
	
	  @GetMapping("totalpublicaciones")
	   public long totalPublicaciones() {
	        return publicacionService.numeroPublicaciones();
	    }
}
