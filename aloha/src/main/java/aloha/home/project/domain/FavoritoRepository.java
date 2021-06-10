package aloha.home.project.domain;

public interface FavoritoRepository {
	
	//Metodo de busqueda segun usuario
	Favorito findById(String id);
	
	//Metodo de busqueda segun usuarios 
	Favorito findByUsuario(String usuario_id);
	
	//Metodo de busqueda segun solicitud
	Favorito findBySolicitud(String solicitud);
}
