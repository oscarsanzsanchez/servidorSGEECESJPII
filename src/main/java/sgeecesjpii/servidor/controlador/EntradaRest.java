package sgeecesjpii.servidor.controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sgeecesjpii.servidor.modelo.Alumno;
import sgeecesjpii.servidor.modelo.Entrada;
import sgeecesjpii.servidor.servicio.AlumnoServicio;
import sgeecesjpii.servidor.servicio.EntradaService;

@RestController
@RequestMapping("/entradas")
public class EntradaRest {

	@Autowired
	private EntradaService entradasServicio;

	@Autowired
	private AlumnoServicio alumnoServicio;

	@GetMapping
	@RequestMapping("/all")
	public ResponseEntity<List<Entrada>> buscarTodos() {
		List<Entrada> entradas;
		entradas = entradasServicio.buscarTodos();

		if (entradas.isEmpty()) {
			return new ResponseEntity<List<Entrada>>(entradas, HttpStatus.NO_CONTENT);
		}

		List<Alumno> alumnosList = alumnoServicio.buscarTodos();
		
		Map<Integer, Alumno> alumnos = new HashMap<>();

		for (Alumno alumno : alumnosList) {
			alumnos.put(alumno.getIdAlumno(), alumno);
		}

		for (Entrada entrada : entradas) {
			entrada.setAlumno(alumnos.get(entrada.getIdAlumno()));
		}

		return new ResponseEntity<List<Entrada>>(entradas, HttpStatus.OK);
	}

	@GetMapping
	@RequestMapping("/{idEntrada}")
	public ResponseEntity<Entrada> buscarUno(@PathVariable("idEntrada") Integer id) {

		ResponseEntity<Entrada> respuesta = null;

		try {
			Entrada entradas = entradasServicio.buscarPorId(id).get();
			Alumno alumno = alumnoServicio.buscarPorId(entradas.getIdAlumno()).get();
			entradas.setAlumno(alumno);
			respuesta = new ResponseEntity<Entrada>(entradas, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			respuesta = new ResponseEntity<Entrada>(new Entrada(), HttpStatus.NO_CONTENT);
		}

		return respuesta;

	}

	@GetMapping
	@RequestMapping("/porhash/{hash}")
	public ResponseEntity<Entrada> buscarUno(@PathVariable("hash") String hash) {

		ResponseEntity<Entrada> respuesta = null;

		try {

			Entrada entrada = entradasServicio.buscarPorHash(hash);

			if (entrada == null) {
				throw new NoSuchElementException();
			}

			respuesta = new ResponseEntity<Entrada>(entrada, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			respuesta = new ResponseEntity<Entrada>(new Entrada(), HttpStatus.NO_CONTENT);
		}

		return respuesta;

	}

	@PostMapping
	@RequestMapping("/nueva")
	public ResponseEntity<Entrada> nueva(@RequestBody Entrada entrada) {

		ResponseEntity<Entrada> respuesta = null;

		Entrada entradaNueva = entradasServicio.nuevaEntrada(entrada);
		try {
			respuesta = new ResponseEntity<Entrada>(entradaNueva, HttpStatus.CREATED);
		} catch (NoSuchElementException e) {
			respuesta = new ResponseEntity<Entrada>(entradaNueva, HttpStatus.NO_CONTENT);
		}

		return respuesta;

	}

}
