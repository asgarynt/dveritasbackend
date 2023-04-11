package com.dveritas.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dveritas.model.Usuario;
import com.dveritas.service.UsuarioService;


@CrossOrigin

@RestController

@RequestMapping(path = "/dveritas/usuarios/") 

public class UsuarioController {

	private final UsuarioService usuarioService;
	

	public UsuarioController (UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	@GetMapping
	public List<Usuario> getUsuarios(){
		return usuarioService.leerUsuarios();
	}
	
	@GetMapping(path="{id}")
	public Usuario getUsuario(@PathVariable("id")Long id) {
		return usuarioService.leerUsuario(id);
	}
	
	@PostMapping
	public void postUsuario(@RequestBody Usuario usuario) { 

		usuarioService.crearUsuario(usuario); 
	}
	
	@PutMapping(path = "{Id}")
	public void updateUsuario(@PathVariable("Id") Long Id, @RequestParam(required = false) String nombre,
			@RequestParam(required = false) String correo, @RequestParam(required = false) String password,
			@RequestParam(required = false) String avatar) {

		usuarioService.actualizarUsuario(Id, nombre, correo, password, avatar);
	}

	  @GetMapping("totalusuarios")
	   public long totalUsuarios() {
	        return usuarioService.numeroUsuarios();
	    }

}