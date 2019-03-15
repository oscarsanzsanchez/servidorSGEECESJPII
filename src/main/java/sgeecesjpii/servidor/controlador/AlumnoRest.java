package sgeecesjpii.servidor.controlador;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sgeecesjpii.servidor.modelo.Alumno;
import sgeecesjpii.servidor.servicio.AlumnoServicio;;

@RestController
@RequestMapping("/alumnos")
public class AlumnoRest {

	@Autowired
	private AlumnoServicio alumnoServicio;

	@GetMapping
	@RequestMapping("/all")
	public ResponseEntity<List<Alumno>> buscarTodos() {
		List<Alumno> alumnos;
		alumnos = alumnoServicio.buscarTodos();
		if (alumnos.isEmpty()) {
			return new ResponseEntity<List<Alumno>>(alumnos, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Alumno>>(alumnos, HttpStatus.OK);
	}

	@GetMapping
	@RequestMapping("/{idAlumno}")
	public ResponseEntity<Alumno> buscarUno(@PathVariable("idAlumno") Integer id) {

		ResponseEntity<Alumno> respuesta = null;

		try {
			Alumno alumno = alumnoServicio.buscarPorId(id).get();
			respuesta = new ResponseEntity<Alumno>(alumno, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			respuesta = new ResponseEntity<Alumno>(new Alumno(), HttpStatus.NO_CONTENT);
		}

		return respuesta;

	}

	@GetMapping
	@RequestMapping("/porapellidos/{apellidos}")
	public ResponseEntity<List<Alumno>> buscarApellidos(@PathVariable("apellidos") String apellidos) {

		ResponseEntity<List<Alumno>> respuesta = null;
		List<Alumno> alumnos = null;
		try {
			alumnos = alumnoServicio.buscarPorApellidos(apellidos);
			respuesta = new ResponseEntity<List<Alumno>>(alumnos, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			respuesta = new ResponseEntity<List<Alumno>>(alumnos, HttpStatus.NO_CONTENT);
		}

		return respuesta;

	}

}
