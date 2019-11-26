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
	
	@Override
	public void crearMateria(Materia materia) {
		dao.crearMateria(materia);
	}

	@Override
	public List<Materia> getAllMateria() {
		return dao.getAllMateria();
	}

}
