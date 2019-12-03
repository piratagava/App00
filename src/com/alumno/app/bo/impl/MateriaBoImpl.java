package com.alumno.app.bo.impl;
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
}
