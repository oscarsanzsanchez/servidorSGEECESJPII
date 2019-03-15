package sgeecesjpii.servidor.servicio;

import java.util.List;
import java.util.Optional;

import sgeecesjpii.servidor.modelo.Entrada;

public interface IEntradaServicio {
	public List<Entrada> buscarTodos();

	public Optional<Entrada> buscarPorId(Integer id);
	
	public Entrada buscarPorHash(String hash);
	
	public Entrada nuevaEntrada(Entrada entrada); 
	
}
