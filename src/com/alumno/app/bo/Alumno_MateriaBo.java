package com.alumno.app.bo;

import java.util.List;

import com.alumno.app.model.AlumnoMateria;

public interface Alumno_MateriaBo {

	public void crearAlumno_Materia(AlumnoMateria alumno_materia);

	public List<AlumnoMateria> getAllAlumnos_Materias();
}
