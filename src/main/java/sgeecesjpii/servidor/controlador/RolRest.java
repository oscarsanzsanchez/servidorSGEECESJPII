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

import sgeecesjpii.servidor.modelo.Rol;
import sgeecesjpii.servidor.servicio.RolServicio;

@RestController
@RequestMapping("/roles")
public class RolRest {

	@Autowired
	private RolServicio rolServicio;

	@GetMapping
	@RequestMapping("/all")
	public ResponseEntity<List<Rol>> buscarTodos() {
		List<Rol> roles;
		roles = rolServicio.buscarTodos();
		if (roles.isEmpty()) {
			return new ResponseEntity<List<Rol>>(roles, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Rol>>(roles, HttpStatus.OK);
	}


	@GetMapping
	@RequestMapping("/{idRol}")
	public ResponseEntity<Rol> buscarUno(@PathVariable("idRol") Integer id) {

		ResponseEntity<Rol> respuesta = null;

		try {
			Rol rol = rolServicio.buscarPorId(id).get();
			respuesta = new ResponseEntity<Rol>(rol, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			respuesta = new ResponseEntity<Rol>(new Rol(-1, "No existe ningún rol con esas características."),
					HttpStatus.NO_CONTENT);
		}
		
		return respuesta;

	}

}
