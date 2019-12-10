package com.alumno.app.dao;

import java.util.List;

import com.alumno.app.model.Materia;

public interface MateriaDao {

	// ---------------Metodos para Materias-----------------------

	public void crearMateria(Materia materia);

	//lista todas las materias
	public List<Materia> getAllMateria();
	
	//consulta por todos que esten en numMaxCupo=0
	public List<Materia> ObtieneMateriasOcupadas();
	
	//materias que ocupa el alumno donde estan en status de numMaxCupo=0
	public List<Materia> ObtieneMateriasOcupadasPorAlumno();
	
	//regresa lista consultada por id
	public Materia consultarMateria(int id_materia);
	
	//metodo que permite la actualizacion de datos
	public void actualizar(Materia materia);
	
	public int[] materiasAsociadas(int id_alumno);
}
