package com.alumno.app.controllers.materia;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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

	// prepara la vista index para agregar nuevo objeto de tipo materia
	@RequestMapping(value = "/registrar_materia", method = RequestMethod.GET)
	public String AgregarMateria() {
		return "registrar_materia";
	}

	// agrega registro de nueva materia
	@RequestMapping(value = "/registrar_materia", method = RequestMethod.POST)
	public @ResponseBody String guardarMateria(@RequestBody Materia materia) {
		try {
			materiaBo.crearMateria(materia);
			return "201";
		} catch (Error e) {
			System.out.println("ERROR AL CREAR LA MATERIA" + e.getMessage());
			return e.getMessage();
		}
	}

	// permite obtener la vista de editar_materia
	@RequestMapping(value = "/editar_materia", method = RequestMethod.GET)
	public String editarMateria() {
		return "editar_materia";
	}

	// metodo que actualiza el registro materia por objeto que llega del json
	@RequestMapping(value = "/editar_materia", method = RequestMethod.PUT)
	public @ResponseBody Boolean actualizarMateria(@RequestBody Materia materia) {
		try {
			materiaBo.actualizar(materia);
			return true;
		} catch (Exception e) {
			e.getMessage();
			return false;
		}
	}

	// consulta lista que obtiene todos los registros de la materia
	@RequestMapping(value = "/listarMateria", method = RequestMethod.GET)
	public @ResponseBody List<Materia> muestraMaterias() {
		List<Materia> lista = materiaBo.getAllMateria();
		return lista;
	}

	// regresa lista de todas las materias que estan en 0
	@RequestMapping(value = "/listarCupoMaximos", method = RequestMethod.GET)
	public @ResponseBody List<Materia> numMaxCupo() {
		List<Materia> lista = materiaBo.ObtieneMateriasOcupadas();
		return lista;
	}

	// regresa lista de acuerdo con join de id_alumno y id_materia que tengan los
	// alumnos con materias en status 0
	@RequestMapping(value = "/listarCupoMaximoPorAlumno", method = RequestMethod.GET)
	public @ResponseBody List<Materia> numMaxCupoPorAlumno() {
		List<Materia> lista = materiaBo.ObtieneMateriasOcupadasPorAlumno();
		return lista;
	}

	// regresa el registro de la materia seleccionada especificamente
	@RequestMapping(value = "/listarConsultaMateria/{id_materia}", method = RequestMethod.GET)
	public @ResponseBody Materia consultaMaterias(@PathVariable int id_materia) {
		return materiaBo.consultarMateria(id_materia);
	}
	
	@RequestMapping(value = "/materiasAsociadas/{id_alumno}", method = RequestMethod.GET)
	public @ResponseBody List<Materia> materiasAsociadas(@PathVariable int id_alumno) {
		return materiaBo.materiasAsociadas(id_alumno);
	}
	
	@RequestMapping(value = "/cupoInicial/{id_materia}", method = RequestMethod.GET)
	public @ResponseBody int cupoInicial(@PathVariable int id_materia) {
		return materiaBo.cupoInicial(id_materia);
	}
}
