package com.dveritas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dveritas.model.Like;


@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {

    Long countByPublicacionId(Long publicacionId);
 
    Like findByUsuarioIdAndPublicacionId(Long idUsuario, Long idPublicacion);
    
}