package aloha.home.project.exception;

public class UsuarioNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	
	//Mensaje de error de usuario
	public UsuarioNotFoundException(String message) {
		super(message);
	}
}
