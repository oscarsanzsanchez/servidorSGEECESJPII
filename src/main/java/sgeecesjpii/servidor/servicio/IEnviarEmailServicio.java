package sgeecesjpii.servidor.servicio;

import org.springframework.mail.SimpleMailMessage;

public interface IEnviarEmailServicio {

	public SimpleMailMessage enviarEmail(String destino, String asunto, String mensaje);
	
	public SimpleMailMessage enviarEmail(String destino, String asunto, String mensaje, String rutaArchivo);
	
	
}
