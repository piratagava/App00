package com.alumno.app.dao.Impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.alumno.app.dao.MateriaDao;
import com.alumno.app.model.Materia;

@Repository
public class MateriaDaoImpl implements MateriaDao {

	@PersistenceContext
	private EntityManager entity;
	
	@Override
	public void crearMateria(Materia materia) {
		entity.persist(materia);
	}

	@SuppressWarnings("unchecked")
	public List<Materia> getAllMateria() {
		Session session = entity.unwrap(Session.class);		
		return session.createQuery("from Materia").list();
	}

}
