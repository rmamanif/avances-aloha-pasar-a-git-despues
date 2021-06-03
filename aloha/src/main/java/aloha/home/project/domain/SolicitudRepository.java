package aloha.home.project.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitudRepository extends JpaRepository<Solicitud, Long>{

	//Búsqueda por tipo de solicitud, por implementar
	List<Solicitud> findByTiposol(String tipo_solicitud);
	
	//Búsqueda por usuario ID, por revisar estructura
	List<Solicitud> findByAndUsuarioid(long id);
	
}
