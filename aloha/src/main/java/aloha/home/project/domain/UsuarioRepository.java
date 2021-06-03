package aloha.home.project.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository
	extends JpaRepository<Usuario, Long>{
	
	//Método de búsqueda para Login, devuelve sólo 1 Registro, esto va de la mano con el index para evitar duplicados de correo
	Usuario findByCorreoAndPassword(String correo, String password);
	
}
