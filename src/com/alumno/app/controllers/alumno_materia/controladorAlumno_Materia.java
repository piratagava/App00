package com.alumno.app.controllers.alumno_materia;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import org.springframework.web.servlet.ModelAndView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@Controller
public class controladorAlumno_Materia {
	
	public static final Logger log = LoggerFactory.getLogger(controladorAlumno_Materia.class);
	
	@Autowired
	private Alumno_MateriaBo alumno_materiaBo;

	// se crea una "vista" a partir de un modelo
	private ModelAndView mav = new ModelAndView();

	// regresa una lista en objetos json
	@RequestMapping(value = "/listarAlumnoMateria", method = RequestMethod.GET)
	public @ResponseBody List<AlumnoMateria> muestraAlumnoMateria() {
		List<AlumnoMateria> lista = alumno_materiaBo.getAllAlumnos_Materias();
		return lista;
	}

	// prepara la vista para poder crear nuevo objeto de tipo Materia
	@RequestMapping(value = "/asignar_materias", method = RequestMethod.GET)
	public ModelAndView AgregarAlumnoMateria() {
		mav.addObject(new AlumnoMateria());
		mav.setViewName("asignar_materias");
		return mav;
	}

	// crea el registro de asociacion alumno y materia
	@RequestMapping(value = "/asignar_materias", method = RequestMethod.POST)
	public @ResponseBody String  guardarAlumnoMateria(@RequestBody List<AlumnoMateria> obtner) {
		// try{
		// }catch (Error e) {
		// System.out.println("ERROR /n"+e.getMessage());
		// return e.getMessage();
		try {
			alumno_materiaBo.crearAlumno_Materia(obtner);
			return "201";			
		} catch (Exception e) {
			log.warn("La materia ya existe en la base de datos");
			log.error(e.getMessage());
			return "existe un error";
		}
	}

	// }

	// retornamos una lista de materias asociadas a los alumnos
	// pathvariable indica que el id la obtiene mediante url desde el front que esta
	// mandando
	@RequestMapping(value = "/consultarAlumno/{id_alumno}", method = RequestMethod.GET)
	public @ResponseBody List<AlumnoMateria> muestraAsociacion(@PathVariable int id_alumno) {
		List<AlumnoMateria> lista = alumno_materiaBo.getIDAllAlumnosMAterias(id_alumno);
		return lista;
	}
	
	@RequestMapping(value = "/materiasOcupadas/{id_materia}", method = RequestMethod.GET)
	public @ResponseBody BigInteger materiasOcupadas(@PathVariable int id_materia) {
		return alumno_materiaBo.materiasOcupadas(id_materia);
	}
}
