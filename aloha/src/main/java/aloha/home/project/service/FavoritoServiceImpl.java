package aloha.home.project.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aloha.home.project.domain.Favorito;
import aloha.home.project.domain.FavoritoRepository;
import aloha.home.project.exception.FavoritoNotFoundException;


@Service
public interface FavoritoServiceImpl implements FvoritoService{
	
	private static final Logger logger = LoggerFactory.getLogger(UsuarioServiceImpl.class);
	
	@Autowired
	FavoritoRepository favoritoRepository;
	
	
	//Implementacion del repositorio
	
	@Override
	public Favorito create(Favorito favorito) {
		return favoritoRepository.save(favorito);
	}
	
	@Override
	public Favorito update(Favorito favorito) {
		return favoritoRepository.save(favorito); 
	}
	
	@Override
	public void delete (long id) throws FavoritoNotFoundException{
		Optional<Favorito> favorito=favoritoRepository.findAll(id);
		if(!favorito.isPresent())
			throw new FavoritoNotFoundException("El destacado no existe");
		return favorito.get();
	}
	
	@Override
	public Iterable<Favorito> findAll(){
		return favoritoRepository.findAll();
	}
	
}
