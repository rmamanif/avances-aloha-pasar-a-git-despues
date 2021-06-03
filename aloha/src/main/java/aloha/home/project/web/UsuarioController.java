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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import aloha.home.project.domain.Usuario;
import aloha.home.project.exception.UsuarioNotFoundException;
import aloha.home.project.service.UsuarioService;


@RestController
@RequestMapping(value="/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {
	//Controlador
	@Autowired
	private UsuarioService service;
	
	@GetMapping
	public Iterable<Usuario> findAll(){
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> getUsuario(@PathVariable long id){
		try {
			return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
		}catch (UsuarioNotFoundException e) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	Usuario create (@RequestBody Usuario newUsuario) {
		return service.create(newUsuario);
	}
	
	@PutMapping("/{id}")
	public Usuario update(@PathVariable("id") Long id, @RequestBody Usuario usuario) {
		
		Usuario newusuario= null;
		try {
			newusuario=service.findById(id);
			newusuario.setApellido(usuario.getApellido());
			newusuario.setNombre(usuario.getNombre());
			newusuario.setCorreo(usuario.getCorreo());
			newusuario.setCelular(usuario.getCelular());
			newusuario.setTelefono(usuario.getTelefono());
			service.update(newusuario);
			
		}catch(UsuarioNotFoundException e) {
			usuario=service.create(newusuario);
		}
			return newusuario;
		}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable long id) {
		try{
			service.delete(id);
			return new ResponseEntity<>("Id del usuario eliminado"+id, HttpStatus.OK);
		}catch (UsuarioNotFoundException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND); 
		}
	}
	
	
	//Login, funciona de la siguiente manera
	//Crea un ResponseEntity, a manera de recibir una respuesta del servidor
	//Requiere de un cuerpo con los valores correo y password
	//Si existe el usuario, devuelve todos sus campos, de esta manera podemos mostrar los datos del perfil
	//El manejo de edición de solicitudes se maneja a través de la entidad solicitudes
	//CRUD "Mi perfil"
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<Usuario> login(@RequestBody Usuario usuario) {
		Usuario usr=new Usuario();
		System.out.println(usuario.getCorreo());
		System.out.println(usuario.getPassword());
		try {
			//Hace uso del servicio para implementar la búsqueda por correo y password
			usr=service.findByCorreoAndPassword(usuario.getCorreo(), usuario.getPassword());
			System.out.println(usuario.getCorreo());
			System.out.println(usuario.getPassword());
			return new ResponseEntity<>(usr, HttpStatus.OK);
		}catch(UsuarioNotFoundException e) {
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
		
	
	
	
}
