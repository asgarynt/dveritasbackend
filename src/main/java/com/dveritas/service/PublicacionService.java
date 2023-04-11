package com.dveritas.service;

import com.dveritas.repository.PublicacionRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dveritas.model.Publicacion;

@Service

public class PublicacionService {

	private final PublicacionRepository publicacionRepository;

	@Autowired
	public PublicacionService(PublicacionRepository publicacionRepository) {

		this.publicacionRepository = publicacionRepository;

	}

	public List<Publicacion> leerPublicaciones() {

		return publicacionRepository.findAll();

	}

	public Publicacion leerPublicacion(Long Id) {

		return publicacionRepository.findById(Id)
				.orElseThrow(() -> new IllegalStateException("El Producto " + "con el id " + Id + " no existe."));

	}

	public void crearPublicacion(Publicacion publicacion) {

		publicacionRepository.save(publicacion);
	}

	public void borrarPublicacion(Long id) {
		if (publicacionRepository.existsById(id)) {
			publicacionRepository.deleteById(id);
		}
	}

	public long numeroPublicaciones() {
        return publicacionRepository.contadorPublicaciones();
    }
	
}
