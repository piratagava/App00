package com.alumno.app.dao.Impl;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.alumno.app.dao.Alumno_MateriaDao;
import com.alumno.app.model.AlumnoMateria;
import com.alumno.app.model.Materia;

@Repository
public class Alumno_MateriaDaoImpl implements Alumno_MateriaDao {

	@PersistenceContext
	private EntityManager entity;
	Materia calculo = new Materia();

	@Override
	public void crearAlumno_Materia(AlumnoMateria alumno_materia) {
		// pendiente
		// int numero= calculo.getNumMaxCupo();
		// int guardar = numero-alumno_materia.getId_materia();
		// this.calculo.setNumMaxCupo(guardar);
		entity.persist(alumno_materia);
	}

	@SuppressWarnings("unchecked")
	public List<AlumnoMateria> getAllAlumnos_Materias() {
		Session session = entity.unwrap(Session.class);
		return session.createQuery("from AlumnoMateria").list();
	}

	// consulta especifica para obtener las materias del alumno que tiene asociado
	@SuppressWarnings("unchecked")
	public List<AlumnoMateria> getIDAllAlumnosMAterias(int id_alumno) {
		Session session = entity.unwrap(Session.class);
		return session.createQuery("from AlumnoMateria where id_alumno=" + id_alumno).list();
	}

	@Override
	public void eliminarAlumnoMateria(AlumnoMateria alumnoMateria) {
		entity.remove(alumnoMateria);
	}

	@SuppressWarnings("unchecked")
	public List<Materia> ObtieneNumMaxMateria(int id_materia) {
		Session session = entity.unwrap(Session.class);
		return session.createQuery("from Materia where id_materia=" + id_materia).list();		
	}
	
	@Override
	public int materiasOcupadas(int id_materia) {
		Session session = entity.unwrap(Session.class);
		String sql = "select count(*) from AlumnoMateria where id_materia = " + id_materia + ";";
		List _numeroDeOcupadas = session.createSQLQuery(sql).list();
		BigInteger numeroDeOcupadas =  (BigInteger) _numeroDeOcupadas.get(0);
		
		String sql2 = "select cupoInicial from Materia where id_materia = " + id_materia + ";";
		List _cupoInicial = session.createSQLQuery(sql2).list();
		int cupoInicial = (int) _cupoInicial.get(0);
		
		String sql3 = "select numMaxCupo from Materia where id_materia = " + id_materia + ";";
		List _disponible =  session.createSQLQuery(sql3).list();
		int disponible = (int)_disponible.get(0);
		System.out.print("");
		if (disponible <= 0) return numeroDeOcupadas.intValue();
		else return cupoInicial;
		
	} 
	
}