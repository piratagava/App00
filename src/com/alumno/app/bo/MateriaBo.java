package com.alumno.app.bo;

import java.util.List;

import com.alumno.app.model.Materia;

public interface MateriaBo {
	// ---------------Metodos para Materias-----------------------

		public void crearMateria(Materia materia);

		public List<Materia> getAllMateria();
}
