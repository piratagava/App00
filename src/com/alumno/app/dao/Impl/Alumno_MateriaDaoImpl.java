package com.alumno.app.dao.Impl;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.alumno.app.dao.Alumno_MateriaDao;
import com.alumno.app.model.AlumnoMateria;
import com.alumno.app.model.Materia;

@Transactional
@Repository
public class Alumno_MateriaDaoImpl implements Alumno_MateriaDao {

	@PersistenceContext
	private EntityManager entity;
	
	@Override
	public void crearAlumno_Materia(AlumnoMateria alumno_materia) {
		Session session = entity.unwrap(Session.class);
		session.persist(alumno_materia);
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
		
		if (disponible <= 0) return numeroDeOcupadas.intValue();
		else return cupoInicial;
	}

	
	@Override
	public boolean eliminarAsociacion(AlumnoMateria alumnoMateria) {
		Session session = entity.unwrap(Session.class);
		AlumnoMateria _alumnoMateria = entity.find(AlumnoMateria.class, alumnoMateria.getId_alumnoMateria());
		
		
		
		if (_alumnoMateria != null) {
			session.delete(_alumnoMateria);
			
			//El sistema deberá obtener el numero actual de cupo en función del materia
			String sql3 = "select numMaxCupo from Materia where id_materia = " + alumnoMateria.getId_materia() + ";";
			List _numActualCupo = session.createSQLQuery(sql3).list();
			
			
			int numeroActualDeCupos = (int)_numActualCupo.get(0);
			numeroActualDeCupos = numeroActualDeCupos + 1;
			
			Materia materia =  entity.find(Materia.class, alumnoMateria.getId_materia());
			materia.setNumMaxCupo(numeroActualDeCupos);
			entity.persist(materia);
			
			//String sqlActualizaCupo = "UPDATE Materia SET numMaxCupo = " + numeroActualDeCupos + " WHERE id_materia = " + alumnoMateria.getId_materia() + ";"; 
			//session.createSQLQuery(sqlActualizaCupo);
			
			return true;
		} else return false;
		
		
	} 
	
}