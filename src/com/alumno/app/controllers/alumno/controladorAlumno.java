package com.alumno.app.controllers.alumno;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alumno.app.bo.AlumnoBo;
import com.alumno.app.model.Alumno;

@Controller
public class controladorAlumno {
	
	@Autowired
	private AlumnoBo alumnoBo;
	
	//Variables de clases, global, local
	private ModelAndView mav = new ModelAndView();
	
	
	@RequestMapping(value = "/", method= RequestMethod.GET)
	public String IniciarIndex() {
		return "index";
	}
	
	@RequestMapping(value = "/listarAlumno", method = RequestMethod.GET)
	public @ResponseBody List<Alumno> muestraAlumnos(){
		List<Alumno> list= alumnoBo.getAllAlumnos();
		return list;
	}
	
	@RequestMapping(value = "/agregarAlumno", method = RequestMethod.GET)
	public ModelAndView Agregar() {				
		mav.addObject(new Alumno());
		mav.setViewName("agregarAlumno");
		return mav;
	}
	
	@RequestMapping(value = "/agregarAlumno", method = RequestMethod.POST)
	public @ResponseBody Boolean guardarAlumno(@RequestBody Alumno alumno) {
		try {
			System.out.print("Alumno +++++++++"+ alumno);			
			alumnoBo.crearAlumno(alumno);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
