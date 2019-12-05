package com.alumno.app.controllers.alumno_materia;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import com.alumno.app.bo.Alumno_MateriaBo;
import com.alumno.app.bo.impl.MateriaBoImpl;
import com.alumno.app.model.AlumnoMateria;
import com.alumno.app.model.Materia;

@Controller
public class controladorAlumno_Materia {

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
	public @ResponseBody String guardarAlumnoMateria(@RequestBody List<AlumnoMateria> obtner) {
		try {
			alumno_materiaBo.crearAlumno_Materia(obtner);
			return "201";
		} catch (Error e) {
			System.out.println("ERROR AL CREAR LA MATERIA" + e.getMessage());
			return e.getMessage();
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

}
