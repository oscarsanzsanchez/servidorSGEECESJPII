package sgeecesjpii.servidor.servicio;

import java.io.File;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EnviarEmailServicio implements IEnviarEmailServicio {

	@Autowired
	public JavaMailSender emailSender;

	@Override
	public SimpleMailMessage enviarEmail(String destino, String asunto, String mensaje) {
		SimpleMailMessage message = new SimpleMailMessage();
		try {
			message.setTo(destino);
			message.setSubject(asunto);
			message.setText(mensaje);
			emailSender.send(message);
		} catch (Exception e) {
			message.setSubject("Error al enviar el E-Mail");
			message.setText("Vaya... parece que algo no ha ido como se esperaba. Prueba de nuevo en unos instantes."
					+ "Si el problema persiste, contacta con un administrador.");
		}

		return message;
	}

	@Override
	public SimpleMailMessage enviarEmail(String destino, String asunto, String mensaje, String rutaArchivo) {
		MimeMessage message = emailSender.createMimeMessage();

		MimeMessageHelper helper;
		try {
			helper = new MimeMessageHelper(message, true);
			helper.setTo(destino);
			helper.setSubject(asunto);
			helper.setText(mensaje);
			
			FileSystemResource file = new FileSystemResource(new File(rutaArchivo));
			helper.addAttachment("entrada.pdf", file);
			emailSender.send(message);
		} catch (Exception e) {
			
		}

		SimpleMailMessage simplemailmessage = new SimpleMailMessage();
		simplemailmessage.setTo(destino);
		simplemailmessage.setSubject(asunto);
		simplemailmessage.setText(mensaje + " || Archivo adjunto: " +rutaArchivo);
		
		return simplemailmessage;
	}
}
