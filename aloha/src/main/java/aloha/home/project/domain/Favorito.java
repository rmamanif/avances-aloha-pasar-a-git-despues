package aloha.home.project.domain;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="favoritos")
public class Favorito {
	//Por hacer, falta investigar de manera correcta Many-to-Many
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;	
	
	
	//implenentacion del manytomany con la tabla usuario
	@ManyToMany
	@JoinColumn(name = "usuario_id")
	Usuario usuaio;
	
	
	//implemetancion del manytomany con la tabla solicitud
	@ManyToMany
	@JoinColumn(name = " solicitud_id")
	Solicitud solicitud;


	
	//ACA FIAJTE BIEN SI ESTA CORRECTO O SI ES QEU FALTA ALGO
	public Favorito() {
		super();
	}
	
	public Favorito(long id, Usuario usuaio, Solicitud solicitud) {
		super();
		this.id = id;
		this.usuaio = usuaio;
		this.solicitud = solicitud;
	}
	


	public Favorito(Usuario usuaio, Solicitud solicitud) {
		super();
		this.usuaio = usuaio;
		this.solicitud = solicitud;
	}

	//crear metodos GETTERS AND SETTERS
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public Usuario getUsuaio() {
		return usuaio;
	}


	public void setUsuaio(Usuario usuaio) {
		this.usuaio = usuaio;
	}


	public Solicitud getSolicitud() {
		return solicitud;
	}


	public void setSolicitud(Solicitud solicitud) {
		this.solicitud = solicitud;
	}

	

	@Override
	public String toString() {
		return "Favorito [id=" + id + ", usuaio=" + usuaio + ", solicitud=" + solicitud + "]";
	}
	

}
