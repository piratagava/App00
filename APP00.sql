drop database APP00;
create database APP00;
  use APP00;


CREATE TABLE Alumno (
  nombre VARCHAR(100) NOT NULL,
  apellidoPaterno VARCHAR(100) NOT NULL,
  apellidoMaterno VARCHAR(100) NOT NULL,
  fechaNacimiento DATE NOT NULL,
  correoElectronico VARCHAR(100) NOT NULL,
  edad INT(11) NOT NULL,
  ruta VARCHAR(100) NOT NULL,
  ultimaModificacion TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  id_alumno INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (id_alumno));


-- -----------------------------------------------------
-- Table APP00.Materia
-- -----------------------------------------------------
CREATE TABLE Materia (
  nombre VARCHAR(100) NOT NULL,
  numMaxCupo INT NOT NULL,
  ultimaModificacion TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  id_materia INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (id_materia));


-- -----------------------------------------------------
-- Table APP00.Alumno_Materia
-- -----------------------------------------------------
CREATE TABLE AlumnoMateria (
  id_alumnoMateria int AUTO_INCREMENT,
  fechaAsociacion DATETIME NOT NULL,
  id_alumno INT NOT NULL,
  id_materia INT NOT NULL,
  foreign key(id_alumno) references Alumno(id_alumno),
  foreign key(id_materia) references Materia(id_materia),
  PRIMARY key(id_alumnoMateria));
  
  ---Sirver para validar que no se repitan los campos de las tablas siendo
  ---unicos y cuando realice la transaccion si no es valido genere error
ALTER TABLE Materia ADD UNIQUE (nombre);
ALTER TABLE Alumno ADD UNIQUE (correoElectronico);
ALTER TABLE AlumnoMateria ADD UNIQUE (id_materia);



para enviar json a post Alumno

    {
        "nombre": "Hernan",
        "apellidoPaterno": "Ga",
        "apellidoMaterno": "Va",
        "fechaNacimiento": "2017-06-15",
        "correoElectronico": "hsepa@gmail.com",
        "edad": 22,
        "ruta": "Disco+D",
        "ultimaModificacion": "2017-06-15",
        "contenido": null
    }


para enviar json a post Materia

     {
        "nombre": "Fisica",
        "numMaxCupo": "20",
        "ultimaModificacion": "2017-06-15"
    }


para enviar relacion foranea Alumno y Materia
    {
        "fechaAsociacion": "2019-06-15",
        "id_alumno": "1",
        "id_materia": "1"
    }







insert into Alumno (nombre,apellidoPaterno,ApellidoMaterno,fechaNacimiento,correoElectronico,edad,ruta,ultimaModificacion,id_alumno) values ('Hernan','Ga','Va','2017-06-15','hsepa@gmail.com','22','Disco+D','2019-11-25',1);

insert into Materia(nombre,numMaxCupo,ultimaModificacion,id_materia) values
('Fisica',5,'2017-06-15',2); insert into Alumno_Materia
(fechaAsociacion,id_alumno,id_materia) values ('2017-06-15',1,2);










drop database APP00;
create database APP00;
  use APP00;


CREATE TABLE Alumno (
  nombre VARCHAR(100) NOT NULL,
  apellidoPaterno VARCHAR(100) NOT NULL,
  apellidoMaterno VARCHAR(100) NOT NULL,
  fechaNacimiento DATE NOT NULL,
  correoElectronico VARCHAR(100) NOT NULL,
  edad INT(11) NOT NULL,
  ruta VARCHAR(100) NOT NULL,
  ultimaModificacion TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  id_alumno INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (id_alumno));


-- -----------------------------------------------------
-- Table APP00.Materia
-- -----------------------------------------------------
CREATE TABLE Materia (
  nombre VARCHAR(100) NOT NULL,
  numMaxCupo INT NOT NULL,
  ultimaModificacion TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  id_materia INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (id_materia));


-- -----------------------------------------------------
-- Table APP00.Alumno_Materia
-- -----------------------------------------------------
CREATE TABLE Alumno_Materia (
  fechaAsociacion DATETIME NOT NULL,
  id_alumno INT NOT NULL,
  id_materia INT NOT NULL,
  foreign key(id_alumno) references Alumno(id_alumno),
  foreign key(id_materia) references Materia(id_materia),
  PRIMARY key(id_alumno,id_materia));
  
  

