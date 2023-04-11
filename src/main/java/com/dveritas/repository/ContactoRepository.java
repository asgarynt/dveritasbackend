package com.dveritas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dveritas.model.Contacto;

public interface ContactoRepository extends JpaRepository<Contacto, Long> { 

	}