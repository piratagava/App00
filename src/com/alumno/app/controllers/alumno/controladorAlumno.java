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
	
	//Variables de clases, global, local, pendiente 
	private ModelAndView mav = new ModelAndView();
		
	//permite iniciar index.html 
	@RequestMapping(value = "/", method= RequestMethod.GET)
	public String IniciarIndex() {
		return "index";
	}
	
	//obtiene la lista completa mediante objetos json las manda a traves peticion get
	@RequestMapping(value = "/listarAlumno", method = RequestMethod.GET)
	public @ResponseBody List<Alumno> muestraAlumnos(){
		List<Alumno> list= alumnoBo.getAllAlumnos();
		return list;
	}
	
	//prepara la vista en este caso index para poder agregar un nuevo registro de tipo persona (objeto)
	@RequestMapping(value = "/agregarAlumno", method = RequestMethod.GET)
	public ModelAndView Agregar() {				
		mav.addObject(new Alumno());
		mav.setViewName("index");
		return mav;
	}
	
	//agrega Alumno mediante peticion post y lo serializa en json
	@RequestMapping(value = "/agregarAlumno", method = RequestMethod.POST)
	public @ResponseBody String guardarAlumno(@RequestBody Alumno alumno) {
		try {			
			alumnoBo.crearAlumno(alumno);
			return "201";
		} catch (Error e) {
			return e.getMessage();			
		}
	}
}
