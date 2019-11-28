package com.alumno.app.controllers.materia;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alumno.app.bo.MateriaBo;
import com.alumno.app.model.Materia;


@Controller
public class controladorMateria {
	
	@Autowired
	private MateriaBo materiaBo;
	
	private ModelAndView mav = new ModelAndView();
	
	
	//regresa lista de todas las materias
	@RequestMapping(value = "/listarMateria", method = RequestMethod.GET)
	public  @ResponseBody List<Materia> muestraMaterias(){
		List<Materia> lista=materiaBo.getAllMateria();
		return lista;
	}
	
	//prepara la vista index para agregar nuevo objeto de tipo materia
	@RequestMapping(value = "/agregarMateria", method = RequestMethod.GET)
	public ModelAndView AgregarMateria() {
		mav.addObject(new Materia());
		mav.setViewName("index");
		return mav;
	}
	
	//agrega registro de nueva materia
	@RequestMapping(value = "/agregarMateria", method = RequestMethod.POST)
	public @ResponseBody Boolean guardarMateria(@RequestBody Materia materia) {	
		try {			
			materiaBo.crearMateria(materia);
			//Si te regresa true es porque no existe nombre repetidos en la tabla de la BD.
			return true;
		} catch (Exception e) {
			System.out.println("ERROR AL CREAR LA MATERIA"+e.getMessage());
			//Si te regresa False la respuesta Post es por Duplicate entry 'nombre' for key 'nombre' se repiten
			return false;		
		}
	}	
}
