package com.alumno.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AlumnoMateria")
public class AlumnoMateria {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_alumnoMateria;

	@Column(name = "id_alumno")
	private int id_alumno;

	@Column(name = "id_materia", unique = true)
	private int id_materia;

	public AlumnoMateria() {
	}

	public AlumnoMateria(int id_alumnoMateria, int id_alumno, int id_materia) {
		super();
		this.id_alumnoMateria = id_alumnoMateria;
		this.id_alumno = id_alumno;
		this.id_materia = id_materia;
	}

	public int getId_alumnoMateria() {
		return id_alumnoMateria;
	}

	public void setId_alumnoMateria(int id_alumnoMateria) {
		this.id_alumnoMateria = id_alumnoMateria;
	}

	public int getId_alumno() {
		return id_alumno;
	}

	public void setId_alumno(int id_alumno) {
		this.id_alumno = id_alumno;
	}

	public int getId_materia() {
		return id_materia;
	}

	public void setId_materia(int id_materia) {
		this.id_materia = id_materia;
	}

	@Override
	public String toString() {
		return  ""+getId_materia();
	}
}
