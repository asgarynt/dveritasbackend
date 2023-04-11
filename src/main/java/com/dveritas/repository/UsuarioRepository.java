package com.dveritas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dveritas.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> { 

	@Query("SELECT usuario FROM Usuario usuario WHERE usuario.correo=?1")
	Optional<Usuario> findByName(String nombre);
	
	@Query("SELECT COUNT(u) FROM Usuario u")
	long contadorUsuarios();
	
	}
