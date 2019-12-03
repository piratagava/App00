package com.alumno.app.dao;

import java.util.List;

import com.alumno.app.model.Materia;

public interface MateriaDao {

	// ---------------Metodos para Materias-----------------------

	public void crearMateria(Materia materia);

	public List<Materia> getAllMateria();
	
	//consulta por todos 0
	public List<Materia> ObtieneMateriasOcupadas();
	
	public List<Materia> ObtieneMateriasOcupadasPorAlumno();
	
	public List<Materia> consultarMateria(int id_materia);
}
