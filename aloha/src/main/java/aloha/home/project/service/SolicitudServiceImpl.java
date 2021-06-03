package aloha.home.project.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aloha.home.project.domain.Solicitud;
import aloha.home.project.domain.SolicitudRepository;
import aloha.home.project.exception.SolicitudNotFoundException;

@Service
public class SolicitudServiceImpl implements SolicitudService {

	private static final Logger logger = LoggerFactory.getLogger(UsuarioServiceImpl.class);
	
	@Autowired
	SolicitudRepository solicitudRepository;

	//Implementación del repositorio, convierte el CRUD en Servicio según las clases del DAO
	
	@Override
	public Solicitud create(Solicitud solicitud) {
		return solicitudRepository.save(solicitud);
	}

	@Override
	public Solicitud update(Solicitud solicitud) {
		return solicitudRepository.save(solicitud);
	}

	@Override
	public void delete(long id) throws SolicitudNotFoundException {
		Solicitud de_sol=findById(id);
		solicitudRepository.delete(de_sol);
	}

	@Override
	public Solicitud findById(long id) throws SolicitudNotFoundException {
		Optional<Solicitud> solicitud=solicitudRepository.findById(id);
		if(!solicitud.isPresent())
			throw new SolicitudNotFoundException("La solicitud no existe");
		return solicitud.get();
	}

	@Override
	public Iterable<Solicitud> findAll() {
		return solicitudRepository.findAll();
	}
	
}
