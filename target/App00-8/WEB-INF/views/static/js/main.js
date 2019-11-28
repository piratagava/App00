'use strict'

const url = "http://127.0.0.1:9090"
	
window.addEventListener('load', () => {
    let entradaFoto = document.querySelector('#iptFoto');
    entradaFoto.addEventListener('change', desplegarFoto);
    
	
	let accionGuardar = document.querySelector("#btnGuardar");	
	accionGuardar.addEventListener('click', () => {
		capturarDatos();
	});
    
    let accionEdad = document.querySelector("#iptFechaNacimiento");    
    accionEdad.addEventListener("blur", () => {
        let fechaNacimiento = document.getElementById("iptFechaNacimiento").value;
        let edad = new Date().getFullYear() - new Date(fechaNacimiento).getFullYear();
        document.getElementById("iptEdad").value = edad;
    });

    let accionGuardarMateria = document.querySelector("#btnGuardarMateria");
    accionGuardarMateria.addEventListener('click',capturarDatosMateria);

});

let capturarDatosMateria = () => {
    let nombre = document.getElementById("iptMateria").value;
    let numMaxCupo = document.getElementById("iptNumMaxCupo").value;
    let materia = {
        "nombre" : nombre,
        "numMaxCupo" : numMaxCupo
    }

    let valido = validarDatosMateria(materia);
        
    if (valido === 1 ) {
        enviarDatosMateria(url+"/agregarMateria", materia);
    } else {
        alert("Capture todos los campos.")
    }

}


let capturarDatos = () => {
    let nombre = document.getElementById("iptNombre").value;
    let apellidoPaterno = document.getElementById("iptApellido1").value;
    let apellidoMaterno = document.getElementById("iptApellido2").value;
    let fechaNacimiento = document.getElementById("iptFechaNacimiento").value;
    let correoElectronico = document.getElementById("iptCorreo").value;
    

    let lector = new FileReader();
    let entradaFoto = document.querySelector('#iptFoto');
    let archivo = entradaFoto.files;
    let blob = new Blob(archivo, {type : 'image/jpeg'})
    
    lector.readAsBinaryString(blob);
    lector.onload = () => {
        let jpge64 = window.btoa(lector.result);
        
        let alumno = {
            "nombre" : nombre,
            "apellidoPaterno" : apellidoPaterno,
            "apellidoMaterno" : apellidoMaterno,
            "fechaNacimiento" : new Date(fechaNacimiento),
            "correoElectronico" : correoElectronico,
            "contenido" : jpge64
        }

        let valido = validarDatos(alumno);
        
        if (valido === 1 ) {
            enviarDatos(url+"/agregarAlumno", alumno);
        } else {
            alert("Capture todos los campos.")
        }
    };
}

let validarDatosMateria = (materia) => {
    let valido = 4;

    if (materia["nombre"].length > 0) valido >>= 1;
    if (materia["numMaxCupo"].length > 0) valido >>= 1;

    console.log(valido);
    return valido;
}

let validarDatos = (alumno) => {
    let valido = 32;

    if (alumno["nombre"].length > 0 ) valido >>= 1; 
    if (alumno["apellidoPaterno"].length > 0) valido >>= 1;
    if (alumno["apellidoMaterno"].length > 0) valido >>= 1;
    if (alumno["fechaNacimiento"].length > 0 ) {    
        alert(alumno["fechaNacimiento"]);
        valido >>= 1 ;
    }
    if (alumno["correoElectronico"].length > 0) valido >>= 1;
    if (alumno["contenido"].length > 0) valido >>= 1;
    console.log(valido);

    return valido;
}

let enviarDatosMateria = (ruta,datosMateria) => {
    fetch(ruta, {
        method : "POST",
        body : JSON.stringify(datosMateria),
        headers : {
            'Content-Type' : 'application/json'
        }
    }).
    then(respuesta => alert(respuesta.status)).
    catch(error => alert(error));
} 

let enviarDatos = (ruta, datosAlumno) => {
    console.log(datosAlumno)
    fetch(ruta, {
		method : 'POST',
		body : JSON.stringify(datosAlumno),
		headers : {
			'Content-Type' : 'application/json'
		}
	}).
    then(respuesta => alert(respuesta.status)).
    catch(error => alert(error));
}

let desplegarFoto = () => {
    let entradaFoto = document.querySelector('#iptFoto');
    let lienzo = document.querySelector("#divLienzo");
    while (lienzo.firstChild) {
        lienzo.removeChild(lienzo.firstChild);
    }

    /**
     * Contiene la información de todos los archivos seleccionado
     */
    let archivo = entradaFoto.files;    
    let foto = document.createElement('img');
    foto.setAttribute("width", "100%");
    foto.src = URL.createObjectURL(archivo[0]);
    lienzo.appendChild(foto);

    return archivo;
}