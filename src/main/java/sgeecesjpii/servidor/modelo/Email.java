package sgeecesjpii.servidor.modelo;

import java.io.Serializable;

public class Email implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String destino;
	private String asunto;
	private String mensaje;
	private String rutaDeArchivo;
	
	public Email() {
		// TODO Auto-generated constructor stub
	}

	public Email(String destino, String asunto, String mensaje) {
		this.destino = destino;
		this.asunto = asunto;
		this.mensaje = mensaje;
	}
	
	public Email(String destino, String asunto, String mensaje, String rutaDeArchivo) {
		this.destino = destino;
		this.asunto = asunto;
		this.mensaje = mensaje;
		this.rutaDeArchivo = rutaDeArchivo;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getRutaDeArchivo() {
		return rutaDeArchivo;
	}

	public void setRutaDeArchivo(String rutaDeArchivo) {
		this.rutaDeArchivo = rutaDeArchivo;
	}
	
	
	
	
}

