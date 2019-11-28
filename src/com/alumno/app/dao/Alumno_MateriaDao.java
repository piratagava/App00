package com.alumno.app.dao;

import java.util.List;

import com.alumno.app.model.AlumnoMateria;

public interface Alumno_MateriaDao {

	//metodos para Asociar Alumno y Materia 
	public void crearAlumno_Materia(AlumnoMateria alumno_materia);
	
	public List<AlumnoMateria> getAllAlumnos_Materias(); 
	
	public List<AlumnoMateria> getIDAllAlumnosMAterias(int id_alumno);
}
