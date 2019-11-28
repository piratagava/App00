package com.alumno.app.bo;

import java.util.List;

import com.alumno.app.model.Materia;

public interface MateriaBo {
	// ---------------Metodos para Materias-----------------------

	// crea materia.
	public void crearMateria(Materia materia);
	//lista que regresa todos los registros de la tabla de la BD.
	public List<Materia> getAllMateria();

}
