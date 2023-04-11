package com.dveritas.service;

import com.dveritas.repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dveritas.model.Usuario;

@Service

public class UsuarioService {

	private final UsuarioRepository usuarioRepository;

	@Autowired
	public UsuarioService(UsuarioRepository usuarioRepository) {

		this.usuarioRepository = usuarioRepository;

	}

	// Leer Contacto (Read)
	public List<Usuario> leerUsuarios() {

		return usuarioRepository.findAll();

	}

	// Leer Contacto (Read)
	public Usuario leerUsuario(Long Id) {

		return usuarioRepository.findById(Id)
				.orElseThrow(() -> new IllegalStateException("El Producto " + "con el id " + Id + " no existe."));

	}
	public void crearUsuario(Usuario usuario) {
		Optional<Usuario> usuarioBuscado = usuarioRepository.findByName(usuario.getCorreo());
		if (usuarioBuscado.isPresent()) {
			throw new IllegalStateException("El Usuario con el nombre" + usuario.getCorreo() + " ya existe.");
		} else {
			usuarioRepository.save(usuario);
		}
	}

	public void actualizarUsuario(Long Id, String nombre, String correo, String password, String avatar) {

		if (usuarioRepository.existsById(Id)) {

			Usuario usuarioABuscar = usuarioRepository.getById(Id);
			if (nombre != null)
				usuarioABuscar.setNombre(nombre);
			if (correo != null)
				usuarioABuscar.setCorreo(correo);
			if (password != null)
				usuarioABuscar.setPassword(password);
			if (avatar != null)
				usuarioABuscar.setAvatar(avatar);
			usuarioRepository.save(usuarioABuscar);
		} else {
			System.out.println("El usuario con el id " + Id + " no existe");
		}
	}

	public long numeroUsuarios() {
        return usuarioRepository.contadorUsuarios();
    }

}