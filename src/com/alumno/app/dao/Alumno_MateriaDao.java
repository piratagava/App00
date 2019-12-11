package com.alumno.app.dao;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import com.alumno.app.model.AlumnoMateria;
import com.alumno.app.model.Materia;

public interface Alumno_MateriaDao {

	//metodos para Asociar Alumno y Materia 
	public void crearAlumno_Materia(AlumnoMateria alumno_materia);	
	
	public List<AlumnoMateria> getAllAlumnos_Materias();
	
	public List<AlumnoMateria> getIDAllAlumnosMAterias(int id_alumno);
	
	public void eliminarAlumnoMateria(AlumnoMateria alumnoMateria);

	public List<Materia> ObtieneNumMaxMateria(int id_alumno);
	
	public int materiasOcupadas(int id_materia);
	
		
}