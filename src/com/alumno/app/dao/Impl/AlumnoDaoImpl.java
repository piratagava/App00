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
		boolean exist = entity.contains(alumno);
		System.out.print("VERIFICANDO SI ESTRA DENTRO DE LA PERSISTENCIA " + exist + "\n");

	}

	@SuppressWarnings("unchecked")
	public List<Alumno> getAllAlumnos() {
		Session session = entity.unwrap(Session.class);
		return session.createQuery("from Alumno").list();
	}

	@Override
	public Alumno consultaAlumno(int id_alumno) {
		Session session = entity.unwrap(Session.class);
		return (Alumno) session.createQuery("from Alumno where id_alumno=" + id_alumno).uniqueResult();
	}

	@Override
	public void actualizarAlumno(Alumno alumno) {
		Session session = entity.unwrap(Session.class);
		session.update(alumno);
	}
	
	public int [] alumnosAsociados(int id_materia) {
		Session session = entity.unwrap(Session.class);
		
		String sql = "select Alumno.id_alumno from Alumno inner join AlumnoMateria where Alumno.id_alumno = AlumnoMateria.id_alumno and AlumnoMateria.id_materia = " + id_materia + ";";
		List alumnos = session.createSQLQuery(sql).list();
		
		int[] _alumnos;
		_alumnos = new int[alumnos.size()];
		
		for(int i = 0; i< alumnos.size(); i ++) {
			_alumnos[i] = (int) alumnos.get(i);
		}
		
		return _alumnos;
	}
}