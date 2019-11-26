package com.alumno.app.dao;

import java.util.List;

import com.alumno.app.model.Alumno;

public interface AlumnoDao {
	
	public void crearAlumno(Alumno alumno);
	
	public List<Alumno> getAllAlumnos();
	
}
