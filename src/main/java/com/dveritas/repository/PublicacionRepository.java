package com.dveritas.repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dveritas.model.Publicacion;


@Repository
public interface PublicacionRepository extends JpaRepository<Publicacion, Long> { 


	@Query("SELECT COUNT(p) FROM Publicacion p")
	    long contadorPublicaciones();
	    
	   @Query("SELECT p FROM Publicacion p ORDER BY p.fecha_publicacion DESC")
	    List<Publicacion> findAllDesc();

	   
	   @Query("SELECT p FROM Publicacion p JOIN p.likes l WHERE p.fecha_publicacion BETWEEN :startDate AND :endDate GROUP BY p.id ORDER BY COUNT(l) DESC")
	   List<Publicacion> findPublicacionesConMasLikesEnRango(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

	   @Query("SELECT p FROM Publicacion p JOIN p.comentarios c WHERE p.fecha_publicacion BETWEEN :startDate AND :endDate GROUP BY p.id ORDER BY COUNT(c) DESC")
	   List<Publicacion> findPublicacionesConMasComentariosEnRango(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
	   
	   List<Publicacion> findByUsuarioId(Long usuarioId);

	   
	}
