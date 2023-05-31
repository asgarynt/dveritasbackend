package com.dveritas.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dveritas.model.Contacto;
import com.dveritas.service.ContactoService;


@RestController

@RequestMapping(path = "/dveritas/contactos/")

public class ContactoController {

	private final ContactoService contactoService;

	public ContactoController(ContactoService contactoService) {
		this.contactoService = contactoService;
	}

	@GetMapping
	public List<Contacto> getComentario() {
		return contactoService.leerContactos();
	}

	@GetMapping(path = "{id}")
	public Contacto getContacto(@PathVariable("id") Long id) {
		return contactoService.leerContacto(id);
	}

	@PostMapping
	public void postContacto(@RequestBody Contacto contacto) {

		contactoService.crearContacto(contacto);
	}

}
