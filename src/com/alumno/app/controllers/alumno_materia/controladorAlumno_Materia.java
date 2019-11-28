package com.alumno.app.controllers.alumno_materia;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	//se crea una "vista" a partir de un modelo
	private ModelAndView mav = new ModelAndView();
	
	//regresa una lista en objetos json
	@RequestMapping(value = "/listarAlumnoMateria", method = RequestMethod.GET)
	public  @ResponseBody List<AlumnoMateria> muestraAlumnoMateria(){
		List<AlumnoMateria> lista=alumno_materiaBo.getAllAlumnos_Materias();
		return lista;
	}
	
	//prepara la vista para poder crear nuevo objeto de tipo Materia
	@RequestMapping(value = "/agregarAlumnoMateria", method = RequestMethod.GET)
	public ModelAndView AgregarAlumnoMateria() {
		mav.addObject(new AlumnoMateria());
		mav.setViewName("index");
		return mav;
	}
	
	//crea el registro de asociacion alumno y materia
	@RequestMapping(value = "/agregarAlumnoMateria", method = RequestMethod.POST)
	public @ResponseBody Boolean guardarAlumnoMateria(@RequestBody AlumnoMateria alumnoMateria) {	
		try {
			alumno_materiaBo.crearAlumno_Materia(alumnoMateria);
			return true;
		} catch (Exception e) {
			System.out.println("ERROR AL CREAR LA MATERIA"+e.getMessage());
			//Si manda falso es porque el alumno no puede registrar la misma materia
			return false;		
		}
	}
	
	//retornamos una lista de materias asociadas a los alumnos
	//pathvariable indica que el id la obtiene mediante url desde el front que esta mandando
		@RequestMapping(value = "/consultarAlumno/{id_alumno}", method = RequestMethod.GET)
		public @ResponseBody List<AlumnoMateria> muestraAsociacion(@PathVariable int id_alumno){
			List<AlumnoMateria> lista=alumno_materiaBo.getIDAllAlumnosMAterias(id_alumno);
			return lista;
		}
				
}
