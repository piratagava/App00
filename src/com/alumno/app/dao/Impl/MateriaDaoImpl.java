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

	@SuppressWarnings("unchecked")
	public List<Materia> ObtieneMateriasOcupadas() {
		Session session = entity.unwrap(Session.class);
		return session.createQuery("from Materia where numMaxCupo=0").list();
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Materia> ObtieneMateriasOcupadasPorAlumno() {
		Session session = entity.unwrap(Session.class);
		return session.createQuery("from Materia where numMaxCupo = 0").list();
	}

	@Override
	public Materia consultarMateria(int id_materia) {
		Session session= entity.unwrap(Session.class);
		//Crear uniqueResult = solo devuelbe un valor
		return	(Materia) session.createQuery("from Materia where id_materia="+id_materia).uniqueResult();
	
	}

	@Override
	public void actualizar(Materia materia) {
		Session actualizar= entity.unwrap(Session.class);
		actualizar.update(materia);
	}
}
