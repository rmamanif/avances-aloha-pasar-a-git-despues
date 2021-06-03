package aloha.home.project.domain;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="favoritos")
public class Favorito {
	//Por hacer, falta investigar de manera correcta Many-to-Many
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;	
	
}
