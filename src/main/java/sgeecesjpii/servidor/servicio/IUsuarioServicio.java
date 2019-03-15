package sgeecesjpii.servidor.servicio;

import java.util.List;
import java.util.Optional;

import sgeecesjpii.servidor.modelo.Usuario;;

public interface IUsuarioServicio {


	
public List<Usuario> buscarTodos();
	
	public Optional<Usuario> buscarPorId(Integer id);
	
}
