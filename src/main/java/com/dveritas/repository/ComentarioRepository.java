package com.dveritas.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dveritas.model.Comentario;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long> { 

	 Long countByPublicacionId(Long publicacionId);
	 
	  @Query("SELECT c FROM Comentario c WHERE c.publicacion.id = :publicacionId")
	    List<Comentario> findByPublicacionId(@Param("publicacionId") Long publicacionId);
	 
	}

	

