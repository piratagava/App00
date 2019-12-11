package com.alumno.app.bo;

import java.util.List;

import com.alumno.app.model.Materia;

public interface MateriaBo {
	// ---------------Metodos para Materias-----------------------

	// crea materia.
	public void crearMateria(Materia materia);

	// lista que regresa todos los registros de la tabla de la BD.
	public List<Materia> getAllMateria();

	public List<Materia> ObtieneMateriasOcupadas();

	public List<Materia> ObtieneMateriasOcupadasPorAlumno();
	
	public Materia consultarMateria(int id_materia);
	
	
	//metodo que permite la actualizacion de datos
	public void actualizar(Materia materia);
	
	public List<Materia> materiasAsociadas(int id_alumno);
	
	public int cupoInicial(int id_materia);
}
