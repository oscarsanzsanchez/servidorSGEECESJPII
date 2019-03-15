package sgeecesjpii.servidor.servicio;

import java.util.List;
import java.util.Optional;

import sgeecesjpii.servidor.modelo.Rol;

public interface IRolServicio {

	public List<Rol> buscarTodos();
	
	public Optional<Rol> buscarPorId(Integer id);
	
}
