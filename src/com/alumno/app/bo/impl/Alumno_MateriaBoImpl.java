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
		//valida para que desde el backend no acepte campos vacios
		if(alumno_materia.getId_alumno()==0 || alumno_materia.getId_materia()==0) {
			System.out.println("NO PUEDES DEJAR CAMPOS VACIOS");
		}else {
			dao.crearAlumno_Materia(alumno_materia);	
		}
		
	}

	//implementacion para retornar la lista
	@Override
	public List<AlumnoMateria> getAllAlumnos_Materias() {
		return dao.getAllAlumnos_Materias();
	}

	//implementacion para retornar una consulta especifica mediante id
	@Override
	public List<AlumnoMateria> getIDAllAlumnosMAterias(int id_alumno) {
		return dao.getIDAllAlumnosMAterias(id_alumno);
	}

}
