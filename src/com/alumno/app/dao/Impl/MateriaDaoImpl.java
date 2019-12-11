package com.alumno.app.dao.Impl;

import java.math.BigInteger;
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

	@Override
	public int[] materiasAsociadas(int id_alumno) {
		Session session = entity.unwrap(Session.class);
		String sql = "SELECT id_materia FROM AlumnoMateria WHERE id_alumno = " + id_alumno + ";";
		List materias = session.createSQLQuery(sql).list();
		int [] idsMaterias = new int[materias.size()];
		
		for(int i = 0; i < materias.size(); i ++) {
			idsMaterias[i] = (int) materias.get(i);
		}
		return idsMaterias;
	}
	
	public int cupoInicial(int id_materia) {
		Session session = entity.unwrap(Session.class);
		String sql = "select count(*) from AlumnoMateria where id_materia = " + id_materia + ";";
		
		List _numMateriaOcupadas = session.createSQLQuery(sql).list();
		BigInteger numMaxCupo = (BigInteger)_numMateriaOcupadas.get(0);
		int numeroMateriaOcupadas = numMaxCupo.intValue();
		
		String sql2 = "select numMaxCupo from Materia where id_materia = " + id_materia + ";";
		List _numMaxCupo = session.createSQLQuery(sql2).list();
		if (_numMaxCupo.size() <= 0) return 0;
		
		int numeroMaxCupo =  (int) _numMaxCupo.get(0);
		return numeroMaxCupo + numeroMateriaOcupadas;
	}
}
