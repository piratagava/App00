package com.alumno.app.bo.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.alumno.app.bo.Alumno_MateriaBo;
import com.alumno.app.dao.Alumno_MateriaDao;
import com.alumno.app.model.AlumnoMateria;

@Service
@Transactional
public class Alumno_MateriaBoImpl implements Alumno_MateriaBo {

	@Autowired
	private Alumno_MateriaDao dao;
	
	@Override
	public void crearAlumno_Materia(AlumnoMateria alumno_materia) {
		dao.crearAlumno_Materia(alumno_materia);
	}	

	@Override
	public List<AlumnoMateria> getAllAlumnos_Materias() {
		return dao.getAllAlumnos_Materias();
	}

}
