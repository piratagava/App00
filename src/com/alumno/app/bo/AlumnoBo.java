package com.alumno.app.bo;

import java.util.List;

import com.alumno.app.model.Alumno;

public interface AlumnoBo {

	public void crearAlumno(Alumno alumno);
	
	public List<Alumno> getAllAlumnos();
	
}
