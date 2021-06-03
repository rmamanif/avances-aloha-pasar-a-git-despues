package aloha.home.project.web;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import aloha.home.project.domain.Solicitud;
import aloha.home.project.domain.Usuario;
import aloha.home.project.exception.SolicitudNotFoundException;
import aloha.home.project.service.SolicitudService;

@RestController
@RequestMapping(value="/solicitud")
@CrossOrigin(origins = "*")
public class SolicitudController {
	
	@Autowired
	SolicitudService service;

	@GetMapping
	public Iterable<Solicitud> findAll(){
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Solicitud> getSolicitud(@PathVariable long id){
		try {
			return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
		}catch (SolicitudNotFoundException e) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	Solicitud create (@RequestBody Solicitud newSolicitud) {
		return service.create(newSolicitud);
	}
	
	@PutMapping("/{id}")
	public Solicitud update(@PathVariable("id") Long id, @RequestBody Solicitud solicitud) {
		
		Solicitud newsolicitud= null;
		try {
			newsolicitud=service.findById(id);
			newsolicitud.setCochera(solicitud.isCochera());
			newsolicitud.setEstado(solicitud.isEstado());
			newsolicitud.setBanos(solicitud.getBanos());
			newsolicitud.setDistrito(solicitud.getDistrito());
			newsolicitud.setProvincia(solicitud.getProvincia());
			newsolicitud.setHabitaciones(solicitud.getHabitaciones());
			newsolicitud.setSuperficie(solicitud.getSuperficie());
			newsolicitud.setPresupuesto(solicitud.getPresupuesto());
			newsolicitud.setTitulo(solicitud.getTitulo());
			newsolicitud.setTiposol(solicitud.getTiposol());
			newsolicitud.setUsuarioid(solicitud.getUsuarioid());
			service.update(newsolicitud);
		}catch(SolicitudNotFoundException e) {
			solicitud=service.create(newsolicitud);
		}
			return newsolicitud;
		}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable long id) {
		try{
			service.delete(id);
			return new ResponseEntity<>("Id de la solicitud eliminado"+id, HttpStatus.OK);
		}catch (SolicitudNotFoundException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND); 
		}
	}
	
	
}
