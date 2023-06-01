package com.dveritas.service;

import com.dveritas.repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.dveritas.utils.SHAUtil;
import com.dveritas.model.Usuario;

@Service

public class UsuarioService {

	private final UsuarioRepository usuarioRepository;

	@Autowired
	public UsuarioService(UsuarioRepository usuarioRepository) {

		this.usuarioRepository = usuarioRepository;

	}

	public List<Usuario> leerUsuarios() {

		return usuarioRepository.findAll();

	}

	public Usuario leerUsuario(Long Id) {

		return usuarioRepository.findById(Id)
				.orElseThrow(() -> new IllegalStateException("El Producto " + "con el id " + Id + " no existe."));

	}
	
	public void crearUsuario(Usuario usuario) {
        Optional<Usuario> correoExistente = usuarioRepository.findByCorreo(usuario.getCorreo());
        Optional<Usuario> nombreExistente = usuarioRepository.findByNombre(usuario.getNombre());
        if (correoExistente.isPresent()) {
            throw new IllegalStateException("El correo ya está en uso intenta con otro");
        } else if (nombreExistente.isPresent()) {
            throw new IllegalStateException("El nombre de usuario ya está en uso intenta con otro");
        } else {
            usuario.setPassword( SHAUtil.createHash(usuario.getPassword()) );
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
				usuarioABuscar.setPassword( SHAUtil.createHash(usuarioABuscar.getPassword()) );
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

	
			public Long obtenerIdUsuarioPorCorreo(String correo) {
			    Optional<Usuario> usuarioOptional = usuarioRepository.findByCorreo(correo);
			    Usuario usuario = usuarioOptional.orElseThrow(() -> new IllegalStateException("El usuario con el correo " + correo + " no existe."));
			    return usuario.getId();
			}

			
			public boolean loginCifrado(String correo, String password) {
				boolean respuesta=false;
				Optional<Usuario> usuario = usuarioRepository.findByCorreo(correo);
				if (usuario.isPresent()) {
					System.out.println("Password SHA: " + SHAUtil.createHash(password));
					if (SHAUtil.verifyHash(password, usuario.get().getPassword()) ) {
						respuesta=true;
				}
			}
				return respuesta;
			}
	
	
}