package com.alumno.app.bo;

import java.util.List;

import com.alumno.app.model.AlumnoMateria;

public interface Alumno_MateriaBo {

	//crear asociacion de Alumno Materia.
	public void crearAlumno_Materia(AlumnoMateria alumno_materia);

	//Creamos una lista para obtener todos los registros de la tabla
	public List<AlumnoMateria> getAllAlumnos_Materias();
	
	//Crear una lista que regresa una consulta especifica del dato id_alumno
	public List<AlumnoMateria> getIDAllAlumnosMAterias(int id_alumno);
}
