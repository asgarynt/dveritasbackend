package com.dveritas.service;

import com.dveritas.repository.ContactoRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dveritas.model.Contacto;

@Service

public class ContactoService {

	
	private final ContactoRepository contactoRepository;
	
	
	
	@Autowired
	public ContactoService (ContactoRepository contactoRepository) {
		
		this.contactoRepository = contactoRepository;
		
	}
		
	public List<Contacto> leerContactos(){
	
		return contactoRepository.findAll(); 	
		
	}
	
	public Contacto leerContacto(Long Id) {
		
		return contactoRepository.findById(Id).orElseThrow(()-> new IllegalStateException("El Producto " + "con el id " + Id + " no existe.") ); 
		
	} 
	
	public void crearContacto(Contacto contacto) {

		contactoRepository.save(contacto); 

	}
}
	
	
