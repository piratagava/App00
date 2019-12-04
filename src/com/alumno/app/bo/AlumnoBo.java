package com.alumno.app.bo;

import java.util.List;

import com.alumno.app.model.Alumno;

public interface AlumnoBo {

	// metodo que crea alumno
	public void crearAlumno(Alumno alumno);

	// creando lista para obtener todos los alumnos
	public List<Alumno> getAllAlumnos();

	public Alumno consultaAlumno(int id_alumno);

	public void actualizarAlumno(Alumno alumno);
}
