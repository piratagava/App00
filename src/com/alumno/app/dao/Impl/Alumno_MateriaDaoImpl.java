package com.alumno.app.dao.Impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.alumno.app.dao.Alumno_MateriaDao;
import com.alumno.app.model.AlumnoMateria;

@Repository
public class Alumno_MateriaDaoImpl implements Alumno_MateriaDao{

	@PersistenceContext
	private EntityManager entity;
	
	@Override
	public void crearAlumno_Materia(AlumnoMateria alumno_materia) {
		entity.persist(alumno_materia);
	}
	
	@SuppressWarnings("unchecked")
	public List<AlumnoMateria> getAllAlumnos_Materias() {
		Session session = entity.unwrap(Session.class);
		return session.createQuery("from AlumnoMateria").list();
	}

}
