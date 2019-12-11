drop database APP00;
create database APP00;
use APP00;


CREATE TABLE Alumno (
  id_alumno INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(100) NOT NULL,
  apellidoPaterno VARCHAR(100) NOT NULL,
  apellidoMaterno VARCHAR(100) NOT NULL,
  fechaNacimiento DATE NOT NULL,
  correoElectronico VARCHAR(100) NOT NULL,
  contenido MEDIUMTEXT NOT NULL,
  PRIMARY KEY (id_alumno));

-- -----------------------------------------------------
-- Table APP00.Materia
-- -----------------------------------------------------
CREATE TABLE Materia (
  id_materia INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(100) NOT NULL,
  numMaxCupo INT NOT NULL,
  cupoInicial INT NOT NULL,
  PRIMARY KEY (id_materia));


-- -----------------------------------------------------
-- Table APP00.Alumno_Materia
-- -----------------------------------------------------
CREATE TABLE AlumnoMateria (
  id_alumnoMateria int AUTO_INCREMENT,
  id_alumno INT NOT NULL,
  id_materia INT NOT NULL,
  foreign key(id_alumno) references Alumno(id_alumno),
  foreign key(id_materia) references Materia(id_materia),
  PRIMARY key(id_alumnoMateria));
  
  ---Sirver para validar que no se repitan los campos de las tablas siendo
  ---unicos y cuando realice la transaccion si no es valido genere error
ALTER TABLE Materia ADD UNIQUE (nombre);
ALTER TABLE Alumno ADD UNIQUE (correoElectronico);

