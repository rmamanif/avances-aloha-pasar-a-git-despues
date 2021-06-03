package aloha.home.project.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aloha.home.project.domain.Usuario;
import aloha.home.project.domain.UsuarioRepository;
import aloha.home.project.exception.UsuarioNotFoundException;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	private static final Logger logger = LoggerFactory.getLogger(UsuarioServiceImpl.class);
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Override
	public Usuario create(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@Override
	public Usuario update(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@Override
	public void delete(long id) throws UsuarioNotFoundException {
		
		Usuario user=findById(id);
		usuarioRepository.delete(user);
	}

	@Override
	public Usuario findById(long id) throws UsuarioNotFoundException {
		Optional<Usuario> usuario=usuarioRepository.findById(id);
		if(!usuario.isPresent())
			throw new UsuarioNotFoundException("Usuario no encontrado...");
		return usuario.get();
	}

	//El método es una clase Usuario, se usa Optional a manera de hacer nulo el resultado
	//Falta optimizar para 404 not found
	@Override
	public Usuario findByCorreoAndPassword(String correo, String password) throws UsuarioNotFoundException {
		Optional<Usuario> user=Optional.of(usuarioRepository.findByCorreoAndPassword(correo, password));
		if(user.isEmpty())
			throw new UsuarioNotFoundException("Usuario no encontrado...");
		return user.get();
	}
	
	@Override
	public Iterable<Usuario> findAll() {
		return usuarioRepository.findAll();
	}
	
}
