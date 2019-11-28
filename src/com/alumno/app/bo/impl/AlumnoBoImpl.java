package com.alumno.app.bo.impl;
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
		//Encode BASE64 codifica pero no la utilizo para recibir datos que me manden de la red
		// byte[] bytesEncoded = Base64.encodeBase64(recibe.getBytes());
		// System.out.println("encoded value is " + new String(bytesEncoded));
		/*
		// 1.- Obenter contenido para decodificar
		String recibe = alumno.getContenido();
		System.out.print("HABER QUE RECIBEEEEEEEEEEEEEEEEE" + recibe);
		
		// 2.- Decodifica el contenido GetDecoder().decode()
		//byte[] decoded = DatatypeConverter.parseBase64Binary(recibe);
	   // byte[] decoded = Base64.decodeBase64(recibe.getBytes());
		//byte[] result = Base64.getDecoder().decode(originalInput);
		//byte[] decoded = Base64.decodeBase64(recibe.getBytes());
		//byte[] decoded = DatatypeConverter.parseBase64Binary(recibe);
		// Decode data on other side, by processing encoded data
		 byte[] decodedBytes = Base64.decode(recibe.getBytes());
		String da= new String(decodedBytes, Charset.forName("UTF-8"));
		// 3.- Crear archivo a partir de la decodificacion
		String name=alumno.getNombre();
		String ruta = "/home/usuario/Documentos/"+name+".jpeg";
		try {
			ObjectOutputStream guarda= new ObjectOutputStream(new FileOutputStream(ruta));
			guarda.write(decodedBytes);
			guarda.close();
			alumno.setRuta.(ruta);
			dao.crearAlumno(alumno);
		} catch (Exception e) {
			System.out.println("LO SIENTO TIO NO SE PUDO GUARDAR LA RUTA");
		}
		*/
		if(alumno.getNombre()==null || alumno.getApellidoPaterno()==null || alumno.getApellidoMaterno()==null || 
				alumno.getCorreoElectronico()==null || alumno.getFechaNacimiento()==null || alumno.getContenido()==null) {
			System.out.print("NO PUEDE INSERTAR CAMṔOS VACIOS");
		}else {
			dao.crearAlumno(alumno);	
		}
		
	}

	//retorna la lista de la tabla alumnos
	@Override
	public List<Alumno> getAllAlumnos() {
		return dao.getAllAlumnos();
	}


}
