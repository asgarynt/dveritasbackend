package com.dveritas.service;

import com.dveritas.repository.PublicacionRepository;
import com.dveritas.repository.ComentarioRepository;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dveritas.model.Comentario;
import com.dveritas.model.Publicacion;

@Service

public class PublicacionService {

	private final PublicacionRepository publicacionRepository;

	private final ComentarioRepository comentarioRepository;

	
	@Autowired
	public PublicacionService(PublicacionRepository publicacionRepository, ComentarioRepository comentarioRepository) {

		this.publicacionRepository = publicacionRepository;
		this.comentarioRepository = comentarioRepository;

	}

	public List<Publicacion> leerPublicaciones() {

		return publicacionRepository.findAllDesc();

	}

	public Publicacion leerPublicacion(Long Id) {

		return publicacionRepository.findById(Id)
				.orElseThrow(() -> new IllegalStateException("El Producto " + "con el id " + Id + " no existe."));

	}

	public Publicacion crearPublicacion(Publicacion publicacion) {
	    return publicacionRepository.save(publicacion);
	}

	public void borrarPublicacion(Long id) {
		if (publicacionRepository.existsById(id)) {
			publicacionRepository.deleteById(id);
		}
	}

	public long numeroPublicaciones() {
        return publicacionRepository.contadorPublicaciones();
    }
	

    public List<Publicacion> obtenerPublicacionesConMasLikesEnRango() {
        LocalDateTime endDate = LocalDateTime.now();
        LocalDateTime startDate = endDate.minus(1, ChronoUnit.MONTHS);
        Date startDateAsDate = Date.from(startDate.atZone(ZoneId.systemDefault()).toInstant());
        Date endDateAsDate = Date.from(endDate.atZone(ZoneId.systemDefault()).toInstant());
        return publicacionRepository.findPublicacionesConMasLikesEnRango(startDateAsDate, endDateAsDate);
    }
    
    public List<Publicacion> obtenerPublicacionesConMasComentariosEnRango() {
        LocalDateTime endDate = LocalDateTime.now();
        LocalDateTime startDate = endDate.minus(1, ChronoUnit.MONTHS);
        Date startDateAsDate = Date.from(startDate.atZone(ZoneId.systemDefault()).toInstant());
        Date endDateAsDate = Date.from(endDate.atZone(ZoneId.systemDefault()).toInstant());
        return publicacionRepository.findPublicacionesConMasComentariosEnRango(startDateAsDate, endDateAsDate);
    }
	
    
    public List<Comentario> comentariosDePublicaciones(Long publicacionId) {
		return comentarioRepository.findByPublicacionId(publicacionId);
    }
    
    public List<Publicacion> leerPublicacionUsuario(Long Id) {
        return publicacionRepository.findByUsuarioId(Id);
    }
    
    
}
