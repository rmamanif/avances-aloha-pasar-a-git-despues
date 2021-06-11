package aloha.home.project.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aloha.home.project.domain.Favorito;
import aloha.home.project.exception.FavoritoNotFoundException;
import aloha.home.project.service.FavoritoService;

@RestController
@RequestMapping(value="/favotiros")
@CrossOrigin(origins = "*")
public class FavoritoController {

	@Autowired
	FavoritoService service;
	
	@GetMapping
	public Iterable<Favorito>findAll(){
		return service.findAll();
	}
	
	
	@GetMapping("/id")
	public ResponseEntity<Favorito> getFavorito(@PathVariable long id){
		try {
			return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
		}catch (FavoritoNotFoundException e) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	
	@DeleteMapping("/id")
	public ResponseEntity<String> delete(@PathVariable long id){
		try {
			service.delete(id);
			return new ResponseEntity<>("ID de favotiro eliminado"+id, HttpStatus.OK);
		}catch (FavoritoNotFoundException e){
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	
}
