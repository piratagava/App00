package com.alumno.app.bo.impl;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.alumno.app.bo.MateriaBo;
import com.alumno.app.dao.MateriaDao;
import com.alumno.app.model.Materia;

@Service
@Transactional
public class MateriaBoImpl implements MateriaBo {

	@Autowired
	private MateriaDao dao;
	
	//metodo para guardar materia
	@Override
	public void crearMateria(Materia materia) {								
		if(materia.getNombre()==null || materia.getNumMaxCupo()==0) {
			System.out.print("NO SE SE DEJE CAMPOS VACIOS");
		}else {
			dao.crearMateria(materia);	
		}
		
	}

	//retorna una lista con los datos de la tabla Materia
	@Override
	public List<Materia> getAllMateria() {
		return dao.getAllMateria();
	}

	@Override
	public List<Materia> ObtieneMateriasOcupadas() {
		return dao.ObtieneMateriasOcupadas();
	}
	
	@Override
	public List<Materia> ObtieneMateriasOcupadasPorAlumno() {
		return dao.ObtieneMateriasOcupadasPorAlumno();
	}

	@Override
	public Materia consultarMateria(int id_materia) {
		return dao.consultarMateria(id_materia);
	}

	@Override
	public void actualizar(Materia materia) {
		dao.actualizar(materia);
	}

	@Override
	public List<Materia> materiasAsociadas(int id_alumno) {
		int[] idsMaterias = dao.materiasAsociadas(id_alumno);
		List<Materia> materias = new ArrayList<Materia>();
		
		for (int i = 0; i < idsMaterias.length; i ++) {
			Materia a = dao.consultarMateria(idsMaterias[i]);
			materias.add(a);
		}
		
		return materias;
	}
}