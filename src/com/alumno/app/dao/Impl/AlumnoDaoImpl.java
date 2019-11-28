package com.alumno.app.dao.Impl;

import java.util.List;
import org.hibernate.Session;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import com.alumno.app.dao.AlumnoDao;
import com.alumno.app.model.Alumno;

@Repository
public class AlumnoDaoImpl implements AlumnoDao {

	@PersistenceContext
	private EntityManager entity;
	
	@Override
	public void crearAlumno(Alumno alumno) {
		entity.persist(alumno);
		System.out.print("AGREGANDO PERSONA CORRECTA \n");
		boolean exist=entity.contains(alumno);
		System.out.print("VERIFICANDO SI ESTRA DENTRO DE LA PERSISTENCIA " + exist + "\n");
		
		
	}

	@SuppressWarnings("unchecked")
	public List<Alumno> getAllAlumnos() {
		Session session = entity.unwrap(Session.class);
		return session.createQuery("from Alumno").list();	
	}
}
