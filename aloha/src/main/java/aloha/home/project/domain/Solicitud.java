package aloha.home.project.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "solicitud")
public class Solicitud {
	//Todos las columnas necesitarán eventualmente la notación @NotNull, por el momento no se aplica ya que estamos haciendo testeo
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column (name="id")
	private long id;
	
	
	//Entidad de tipo padre bidireccional OneToMany - ManyToOne
	//JoinColumn referencia el Long en vez de la entidad, cada vez que se crea algo en la entidad Usuario,
	//Solicitud tomará como llave referencial un ID en vez de la entidad completa
	@ManyToOne
	@JoinColumn(name="usuarioid", insertable = false, updatable = false)
	private Usuario usuario;
	
	//Llave foránea Numeral en vez de clase
	private long usuarioid;
	
	@Column(name="titulo")
	private String titulo;
	
	@Column(name="tiposol")
	private String tiposol;
	
	@Column(name="superficie")
	private int superficie;
	
	@Column(name="provincia")
	private String provincia;
	
	@Column(name="distrito")
	private String distrito;
	
	@Column(name="habitaciones")
	private int habitaciones;
	
	@Column(name="banos")
	private int banos;
	
	//Dinero que posee el solicitante
	@Column(name="presupuesto")
	private int presupuesto;
	
	@Column(name="cochera")
	private boolean cochera;
	
	
	//Estado de la solicitud, se diferencia de eliminar ya que esta sólo cambia la visibilidad en la página,
	//mantiene la solicitud en la DB y Spring
	@Column(name="estado")
	private boolean estado;
	
	public Solicitud() {
		super();
	}

	public Solicitud(long usuarioid, String titulo, String tiposol, int superficie, String provincia, String distrito,
			int habitaciones, int banos, int presupuesto, boolean cochera, boolean estado) {
		super();
		this.usuarioid = usuarioid;
		this.titulo = titulo;
		this.tiposol = tiposol;
		this.superficie = superficie;
		this.provincia = provincia;
		this.distrito = distrito;
		this.habitaciones = habitaciones;
		this.banos = banos;
		this.presupuesto = presupuesto;
		this.cochera = cochera;
		this.estado = estado;
	}




	public Solicitud(Usuario usuario, long usuarioid, String titulo, String tiposol, int superficie, String provincia,
			String distrito, int habitaciones, int banos, int presupuesto, boolean cochera, boolean estado) {
		super();
		this.usuario = usuario;
		this.usuarioid = usuarioid;
		this.titulo = titulo;
		this.tiposol = tiposol;
		this.superficie = superficie;
		this.provincia = provincia;
		this.distrito = distrito;
		this.habitaciones = habitaciones;
		this.banos = banos;
		this.presupuesto = presupuesto;
		this.cochera = cochera;
		this.estado = estado;
	}




	public Solicitud(long id, Usuario usuario, long usuarioid, String titulo, String tiposol, int superficie,
			String provincia, String distrito, int habitaciones, int banos, int presupuesto, boolean cochera,
			boolean estado) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.usuarioid = usuarioid;
		this.titulo = titulo;
		this.tiposol = tiposol;
		this.superficie = superficie;
		this.provincia = provincia;
		this.distrito = distrito;
		this.habitaciones = habitaciones;
		this.banos = banos;
		this.presupuesto = presupuesto;
		this.cochera = cochera;
		this.estado = estado;
	}




	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	//Esta anotación evita el error de la recursión infinita
	//https://stackoverflow.com/questions/31319358/jsonmanagedreference-vs-jsonbackreference
	@JsonBackReference
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTiposol() {
		return tiposol;
	}

	public void setTiposol(String tiposol) {
		this.tiposol = tiposol;
	}

	public int getSuperficie() {
		return superficie;
	}

	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public int getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(int habitaciones) {
		this.habitaciones = habitaciones;
	}

	public int getBanos() {
		return banos;
	}

	public void setBanos(int banos) {
		this.banos = banos;
	}

	public int getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(int presupuesto) {
		this.presupuesto = presupuesto;
	}

	public boolean isCochera() {
		return cochera;
	}

	public void setCochera(boolean cochera) {
		this.cochera = cochera;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public long getUsuarioid() {
		return usuarioid;
	}



	public void setUsuarioid(long usuarioid) {
		this.usuarioid = usuarioid;
	}



	@Override
	public String toString() {
		return "Solicitud [id=" + id + ", usuario=" + usuario + ", usuarioid=" + usuarioid + ", titulo=" + titulo
				+ ", tiposol=" + tiposol + ", superficie=" + superficie + ", provincia=" + provincia + ", distrito="
				+ distrito + ", habitaciones=" + habitaciones + ", banos=" + banos + ", presupuesto=" + presupuesto
				+ ", cochera=" + cochera + ", estado=" + estado + "]";
	}

	

	
	
}
