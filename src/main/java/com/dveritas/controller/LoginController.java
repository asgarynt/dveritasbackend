package com.dveritas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dveritas.model.Usuario;
import com.dveritas.service.UsuarioService;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


//@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
//        RequestMethod.PUT })
@RestController
@RequestMapping(path="/dveritas/login/")

public class LoginController {
	
	// Constante para el autowired
	
	private final UsuarioService usuarioService;
	
	// Agregamos la anotacion para la inyeccion
	@Autowired
		
	//Creamos un constructor
	
	public LoginController (UsuarioService usuarioService) {
		this.usuarioService = usuarioService;		
	}
	
	//Metodo post para iniciar sesion 
		@PostMapping
		public Boolean Login(@RequestBody Usuario usuario) {
			Boolean respuesta=false;
			if (usuarioService.loginCifrado(usuario.getCorreo(), usuario.getPassword())){
				respuesta = true;
			}
			return respuesta;
		}	

		// Metodo para traer el ID usando el correo
		@GetMapping(path="{correo}")
		public ResponseEntity<Long> obtenerIdUsuarioPorCorreo(@PathVariable String correo) {
		    Long idUsuario = usuarioService.obtenerIdUsuarioPorCorreo(correo);
		    return ResponseEntity.ok(idUsuario);
		}		
	
	
}