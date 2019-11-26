package com.alumno.app.model;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Materia")
public class Materia {
	

	@Column(name="nombre", unique=true)
	private String nombre;
	
	@Column(name="numMaxCupo")
	private int numMaxCupo;
	
	@Column(name="ultimaModificacion")
	private Date ultimaModificacion;//si genera error en fecha cambiar util.sql en libreria import
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_materia;
	
	
	public  Materia() {
		
	}

	public Materia(int id_materia, String nombre, int numMaxCupo, Date ultimaModificacion) {
		super();
		this.id_materia = id_materia;
		this.nombre = nombre;
		this.numMaxCupo = numMaxCupo;
		this.ultimaModificacion = ultimaModificacion;
	}

	public int getId_materia() {
		return id_materia;
	}

	public void setId_materia(int id_materia) {
		this.id_materia = id_materia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumMaxCupo() {
		return numMaxCupo;
	}

	public void setNumMaxCupo(int numMaxCupo) {
		this.numMaxCupo = numMaxCupo;
	}

	public Date getUltimaModificacion() {
		return ultimaModificacion;
	}

	public void setUltimaModificacion(Date ultimaModificacion) {
		this.ultimaModificacion = ultimaModificacion;
	}	
	
}
