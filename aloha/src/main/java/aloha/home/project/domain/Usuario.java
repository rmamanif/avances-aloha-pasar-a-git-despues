package aloha.home.project.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.Nullable;

@Entity
@Table(name="usuario", indexes = {@Index(name="no_dupe_correo",columnList = "correo", unique = true)}) //Index=No duplicado sin ser PK
public class Usuario {
	
	//Todos las columnas necesitarán eventualmente la notación @NotNull, por el momento no se aplica ya que estamos haciendo testeo
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="id")
	private long id;
	
	@Column (name="correo")
	private String correo;
	@Column (name="nombre")
	private String nombre;
	@Column (name="apellido")
	private String apellido;
	@Column(name ="contrasena")
	private String password;
	@Column(name ="nro_telefono")
	private String telefono;
	@Column(name ="nro_celular")
	private String celular;
	
	//Esta columna no sirve, eventualmente la borraremos si nos falta tiempo para implementar una seguridad real
	@Column(name ="token")
	private String token;
	
	//Entidad mapeada, toma el rol de hijo
	//Con esto se relaciona el id del usuario con el fk, evitar cambiar el auto_increment de manera manual en SQL
	@OneToMany(mappedBy = "usuarioid", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Solicitud> solicitudes;
	
	
	//Evita la recursión, para más información revisa el link de abajo
	//https://stackoverflow.com/questions/31319358/jsonmanagedreference-vs-jsonbackreference
	@JsonManagedReference
	public List<Solicitud> getSolicitudes() {
		return solicitudes;
	}


	public void setSolicitudes(List<Solicitud> solicitudes) {
		this.solicitudes = solicitudes;
	}


	public Usuario(long id, String correo, String nombre, String apellido, String password, String telefono,
			String celular, String token, List<Solicitud> solicitudes) {
		super();
		this.id = id;
		this.correo = correo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.password = password;
		this.telefono = telefono;
		this.celular = celular;
		this.token = token;
		this.solicitudes = solicitudes;
	}


	public Usuario() {
		super();
	}

	
	public Usuario(String correo, String password) {
		super();
		this.correo = correo;
		this.password = password;
	}


	public Usuario(long id, String correo, String nombre, String apellido, String password, String telefono,
			String celular, String token) {
		super();
		this.id = id;
		this.correo = correo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.password = password;
		this.telefono = telefono;
		this.celular = celular;
		this.token = token;
	}
	
	public Usuario(String correo, String nombre, String apellido, String password, String telefono, String celular,
			String token) {
		super();
		this.correo = correo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.password = password;
		this.telefono = telefono;
		this.celular = celular;
		this.token = token;
	}

	public Usuario(String correo, String nombre, String apellido, String password, String telefono, String celular) {
		super();
		this.correo = correo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.password = password;
		this.telefono = telefono;
		this.celular = celular;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "Usuario [id=" + id + ", correo=" + correo + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", password=" + password + ", telefono=" + telefono + ", celular=" + celular + ", token=" + token
				+ ", solicitudes=" + solicitudes + "]";
	}

	
}
