package sgeecesjpii.servidor.controlador;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sgeecesjpii.servidor.modelo.Email;
import sgeecesjpii.servidor.servicio.EnviarEmailServicio;

@RestController
@RequestMapping(value = "/enviarEmail")
public class EmailRest {

	@Autowired
	private EnviarEmailServicio enviarEmailServicio;
	
	@PostMapping
	@RequestMapping(value = "/")
	public SimpleMailMessage enviarEmail(@RequestBody Email email){
		
		if (email.getRutaDeArchivo().isEmpty()) {
			return enviarEmailServicio.enviarEmail(email.getDestino(), email.getAsunto(), email.getMensaje());

		}else {
			return enviarEmailServicio.enviarEmail(email.getDestino(), email.getAsunto(), email.getMensaje(), email.getRutaDeArchivo());

		}
	}
	
	
}
