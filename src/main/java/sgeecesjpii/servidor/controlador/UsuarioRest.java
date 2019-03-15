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

import sgeecesjpii.servidor.modelo.Usuario;
import sgeecesjpii.servidor.servicio.UsuarioServicio;

@RestController
@RequestMapping("/usuarios")
public class UsuarioRest {

	@Autowired
	private UsuarioServicio usuarioServicio;

	@GetMapping
	@RequestMapping("/all")
	public ResponseEntity<List<Usuario>> buscarTodos() {
		List<Usuario> usuarios;
		usuarios = usuarioServicio.buscarTodos();
		if (usuarios.isEmpty()) {
			return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
	}

	@GetMapping
	@RequestMapping("/{idUsuario}")
	public ResponseEntity<Usuario> buscarUno(@PathVariable("idUsuario") Integer id) {

		ResponseEntity<Usuario> respuesta = null;

		try {
			Usuario usuario = usuarioServicio.buscarPorId(id).get();
			respuesta = new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			respuesta = new ResponseEntity<Usuario>(new Usuario(), HttpStatus.NO_CONTENT);
		}

		return respuesta;

	}

}
