package com.alumno.app.bo;

import java.util.List;

import com.alumno.app.model.AlumnoMateria;
import com.alumno.app.model.Materia;

public interface Alumno_MateriaBo {

	// crear asociacion de Alumno Materia.
	public List<Materia> crearAlumno_Materia(List<AlumnoMateria> ListCrear);

	// Creamos una lista para obtener todos los registros de la tabla
	public List<AlumnoMateria> getAllAlumnos_Materias();

	// Crear una lista que regresa una consulta especifica del dato id_alumno
	public List<AlumnoMateria> getIDAllAlumnosMAterias(int id_alumno);

	public void eliminarAlumnoMateria(AlumnoMateria alumnoMateria);

	public List<Materia> ObtieneNumMaxMateria(int id_alumno);

}