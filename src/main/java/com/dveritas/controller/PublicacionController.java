package com.dveritas.controller;

import java.io.File;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dveritas.model.Comentario;
import com.dveritas.model.Publicacion;
import com.dveritas.service.PublicacionService;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;



//@CrossOrigin("*")

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
	
	@PostMapping("post")
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
	  
	    @GetMapping("likes")
	    public List<Publicacion> obtenerPublicacionesConMasLikesEnRango() {
	        return publicacionService.obtenerPublicacionesConMasLikesEnRango();
	    }
	    
	    @GetMapping("comentarios")
	    public List<Publicacion> obtenerPublicacionesConMasComentariosEnRango() {
	        return publicacionService.obtenerPublicacionesConMasComentariosEnRango();
	    }
	  
	    
	    @GetMapping("comentarios/{Id}")
	    public List<Comentario> comentariosEnPublicaciones(@PathVariable("Id") Long Id) {
	        return publicacionService.comentariosDePublicaciones(Id);
	    }
	  
	    @GetMapping(path="/usuario/{id}")
	    public List<Publicacion> getPublicacionUsuario(@PathVariable("id")Long id) {
	        return publicacionService.leerPublicacionUsuario(id);
	    }
	    
	    
	    @GetMapping("/imagenes/{nombreImagen}")
	    public ResponseEntity<Resource> obtenerImagen(@PathVariable String nombreImagen) {
	        // Construye la ruta completa de la imagen en el directorio /src/main/webapp
	        String rutaImagen = "src/main/webapp/" + nombreImagen;
	        File imagenFile = new File(rutaImagen);

	        if (imagenFile.exists()) {
	            Resource imagen = new FileSystemResource(imagenFile);

	            return ResponseEntity.ok()
	                    .contentType(MediaType.IMAGE_JPEG)
	                    .body(imagen);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	}
	    

