package com.alumno.app.controllers.alumno_materia;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.alumno.app.bo.Alumno_MateriaBo;
import com.alumno.app.model.AlumnoMateria;
import com.alumno.app.model.Materia;

@Controller
public class controladorAlumno_Materia {

	@Autowired 
	private Alumno_MateriaBo alumno_materiaBo;
	
	
	private ModelAndView mav = new ModelAndView();
	
	@RequestMapping(value = "/listarAlumnoMateria", method = RequestMethod.GET)
	public  @ResponseBody List<AlumnoMateria> muestraAlumnoMateria(){
		List<AlumnoMateria> lista=alumno_materiaBo.getAllAlumnos_Materias();
		return lista;
	}
	
	
	@RequestMapping(value = "/agregarAlumnoMateria", method = RequestMethod.GET)
	public ModelAndView AgregarAlumnoMateria() {
		mav.addObject(new Materia());
		mav.setViewName("/Alumno_Materia/agregarAlumnoMateria");
		return mav;
	}
	
	@RequestMapping(value = "/agregarAlumnoMateria", method = RequestMethod.POST)
	public @ResponseBody Boolean guardarAlumnoMateria(@RequestBody AlumnoMateria alumnoMateria) {	
		try {
			alumno_materiaBo.crearAlumno_Materia(alumnoMateria);
			return true;
		} catch (Exception e) {
			System.out.println("ERROR AL CREAR LA MATERIA"+e.getMessage());
			return false;		
		}
	}	
}
