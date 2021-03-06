package com.alumno.app.controllers.alumno;

import java.util.List;
import java.util.logging.Logger;

import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.alumno.app.bo.AlumnoBo;
import com.alumno.app.model.Alumno;

@Controller("/principal")
public class controladorAlumno {

	//public static final Logger log = (Logger) LoggerFactory.getLogger(controladorAlumno.class);
	
	@Autowired
	private AlumnoBo alumnoBo;

	// Variables de clases, global, local, pendiente
	
	// permite iniciar index.html
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String IniciarIndex() {
		return "index";
	}

	// obtiene la lista completa mediante objetos json las manda a traves peticion
	// get
	@RequestMapping(value = "/listarAlumno", method = RequestMethod.GET)
	public @ResponseBody List<Alumno> muestraAlumnos() {
		List<Alumno> list = alumnoBo.getAllAlumnos();
		return list;
	}

	// obtiene registro mediante objetos json
	@RequestMapping(value = "/consultaAlumno/{id_alumno}", method = RequestMethod.GET)
	public @ResponseBody Alumno consultaAlumnos(@PathVariable int id_alumno) {
		return alumnoBo.consultaAlumno(id_alumno);
	}

	// prepara la vista en este caso index para poder agregar un nuevo registro de
	// tipo persona (objeto)
	@RequestMapping(value = "/alta_alumno", method = RequestMethod.GET)
	public String Agregar() {
		return "alta_alumno";
	}

	// agrega Alumno mediante peticion post y lo serializa en json
	@RequestMapping(value = "/alta_alumno", method = RequestMethod.POST)
	public @ResponseBody String guardarAlumno(@RequestBody Alumno alumno) {
		try {
			alumnoBo.crearAlumno(alumno);
			return "201";
		} catch (Error e) {
			return e.getMessage();
		}
	}

   @RequestMapping(value="/actualizar_alumno",method = RequestMethod.GET)
   public String actualizar_alumno() {
		return "actualizar_alumno";
	}

	// agrega Alumno mediante peticion post y lo serializa en json
	@RequestMapping(value = "/actualizar_alumno", method = RequestMethod.PUT)
	public @ResponseBody Boolean actualizaAlumno(@RequestBody Alumno alumno) {
		try {
			alumnoBo.actualizarAlumno(alumno);
			return true;
		} catch (Error e) {
			return false;
		}
	}

	// permite iniciar index.html
	@RequestMapping(value = "/regresar", method = RequestMethod.GET)
	public String RegresarIndex() {
		return "index";
	}
	
	@RequestMapping(value = "/alumnosAsociados/{id_materia}", method = RequestMethod.GET)
	public @ResponseBody List<Alumno> alumnosAsociados(@PathVariable int id_materia) {
		return alumnoBo.alumnosAsociados(id_materia);
	}
}
