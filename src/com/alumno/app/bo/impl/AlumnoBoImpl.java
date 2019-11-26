package com.alumno.app.bo.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alumno.app.bo.AlumnoBo;
import com.alumno.app.dao.AlumnoDao;
import com.alumno.app.model.Alumno;

@Service
//@Service indica que la clase es un bean de la capa de negocio
@Transactional
public class AlumnoBoImpl implements AlumnoBo {

	@Autowired
	private AlumnoDao dao;
	
	@Override
	public void crearAlumno(Alumno alumno) {
		
	Calendar fecha = new GregorianCalendar();
	int anioActual = fecha.get(Calendar.YEAR);
	int  mesActual = Calendar.getInstance().get(Calendar.MONTH)+1;
	int diaActual = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
	       
	int anio= alumno.getFechaNacimiento().getYear();
	int mes= alumno.getFechaNacimiento().getMonth()+1;
	int dia= alumno.getFechaNacimiento().getDay();
	
	System.out.println("FECHA EXTRAÑAAAAA "+ anio + " mes " + mes + " " + dia );

	System.out.println("MUESTRAAAAAAAAAAA FECHA CORRECTA "+ alumno.getFechaNacimiento());
	
	
		dao.crearAlumno(alumno);
	}

	@Override
	public List<Alumno> getAllAlumnos() {
		return dao.getAllAlumnos();
	}
	
}
