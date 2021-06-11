package aloha.home.project.service;

import aloha.home.project.domain.Favorito;
import aloha.home.project.exception.FavoritoNotFoundException;

public interface FavoritoService {
	//DAO
	//CREATE
	Favorito create(Favorito usuario_id);
	
	//UPDATE
	Favorito update(Favorito usuario_id);
	
	//DELETE
	void delete(long id) throws FavoritoNotFoundException;
	
	//IMPLEMENTACION DE BUSQUEDAS
	//POR USUARIO
	Favorito findById(long id)  throws FavoritoNotFoundException;
	
	//MOSTRAR TODO
	Iterable<Favorito> findAll();
	
}
