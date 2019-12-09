package com.alumno.app.bo.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.HttpConstraint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.alumno.app.bo.Alumno_MateriaBo;
import com.alumno.app.dao.Alumno_MateriaDao;
import com.alumno.app.model.AlumnoMateria;
import com.alumno.app.model.Materia;

@Service
@Transactional
public class Alumno_MateriaBoImpl implements Alumno_MateriaBo {

	@Autowired
	private Alumno_MateriaDao dao;

	@Override
	@HttpConstraint
	public List<Materia> crearAlumno_Materia(List<AlumnoMateria> ListCrear) {
		List<Materia> materiasOcupadas = new ArrayList();
		List<AlumnoMateria> listTablaDB = getIDAllAlumnosMAterias(ListCrear.get(0).getId_alumno());
		// condicion si lista materia viene en 0 para eliminar todas las asociaciones
		if (ListCrear.get(0).getId_materia() == 0) {
			for (AlumnoMateria itemValue : listTablaDB) {
				if (existeElementoenLista(ListCrear, itemValue)) {
					System.out.print("Hay almenos una Coincidencia");
				} else {
					dao.eliminarAlumnoMateria(itemValue);
					List<Materia> consulta = ObtieneNumMaxMateria(itemValue.getId_materia());
					for (Materia registra : consulta) {
						int max = registra.getNumMaxCupo();
						System.out.print("SOYYYYYY NUMERO MAXIMO " + max + "\n");
						int resultado = max + 1;
						registra.setNumMaxCupo(resultado);
						System.out.print("TERMINE DE OPERAR SETEEEEEEEOOOOOO " + resultado + "\n");
					}
				}
			}
		} else {
			// si la tabla de AlumnoMateria existen datos entra la condicion
			if (listTablaDB.size() > 0) {
				for (AlumnoMateria itemBD : listTablaDB) {
					if (existeElementoenLista(ListCrear, itemBD)) {
						System.out.print("Elemento Existe en Tabla de BD");
					} else {
						dao.eliminarAlumnoMateria(itemBD);
						List<Materia> consulta = ObtieneNumMaxMateria(itemBD.getId_materia());
						for (Materia registra : consulta) {
							int max = registra.getNumMaxCupo();
							System.out.print("SOYYYYYY NUMERO MAXIMO " + max + "\n");
							int resultado = max + 1;
							registra.setNumMaxCupo(resultado);
							System.out.print("TERMINE DE OPERAR SETEEEEEEEOOOOOO " + resultado + "\n");
						}
					}
				}

				for (AlumnoMateria fronList : ListCrear) {
					if (existeElementoenLista(listTablaDB, fronList)) {
						System.out.print("Elemento existe ya");
					} else {
						System.out.print(
								" CREANDO NUEVO REGISFTRO EN LA TABLA ALUMNO MATERIA" + fronList.getId_materia());
						List<Materia> consulta = ObtieneNumMaxMateria(fronList.getId_materia());
						for (Materia registra : consulta) {
							int max = registra.getNumMaxCupo();
							System.out.print("SOYYYYYY NUMERO MAXIMO " + max + "\n");
							// Modifique con try catch

							if (max <= 0) {
								materiasOcupadas.add(registra);
								break;
							} else {
								int resultado = max - 1;
								registra.setNumMaxCupo(resultado);
								dao.crearAlumno_Materia(fronList);
								System.out.print("SEGUN TERMINE DE OPERAR SETEEEEEEEOOOOOO " + resultado + "\n");
							}

						}
					}
				}
				// si la tabla de AlumnoMateria no existen registro inicialmente los crea
			} else {
				for (AlumnoMateria registraComoVieneDelFront : ListCrear) {
					// creo la lista materia para obtener NumMaxCupo y setearlo mediante id_materia
					// que guardo
					List<Materia> consulta = ObtieneNumMaxMateria(registraComoVieneDelFront.getId_materia());
					for (Materia registra : consulta) {
						int max = registra.getNumMaxCupo();
						System.out.print("SOYYYYYY NUMERO MAXIMO " + max + "\n");
						// sufrio modificaciones
						if (max <= 0) {
							materiasOcupadas.add(registra);
							break;
						} else {
							int resultado = max - 1;
							registra.setNumMaxCupo(resultado);
							dao.crearAlumno_Materia(registraComoVieneDelFront);
							System.out.print("SEGUN TERMINE DE OPERAR SETEEEEEEEOOOOOO " + resultado + "\n");						
						}

					}

				}
			}
		}
		return materiasOcupadas;
	}

	public Boolean existeElementoenLista(List<AlumnoMateria> lista, AlumnoMateria itemAcomparar) {
		for (AlumnoMateria item : lista) {
			if (item.getId_alumno() == itemAcomparar.getId_alumno()
					&& item.getId_materia() == itemAcomparar.getId_alumnoMateria()) {
				return true;
			}
		}
		return false;
	}

	// implementacion para retornar la lista
	@Override
	public List<AlumnoMateria> getAllAlumnos_Materias() {
		return dao.getAllAlumnos_Materias();
	}

	// implementacion para retornar una consulta especifica mediante id
	@Override
	public List<AlumnoMateria> getIDAllAlumnosMAterias(int id_alumno) {
		return dao.getIDAllAlumnosMAterias(id_alumno);
	}

	@Override
	public void eliminarAlumnoMateria(AlumnoMateria alumnoMateria) {
		dao.eliminarAlumnoMateria(alumnoMateria);
	}

	@Override
	@Transactional
	public List<Materia> ObtieneNumMaxMateria(int id_alumno) {
		return dao.ObtieneNumMaxMateria(id_alumno);
	}

}