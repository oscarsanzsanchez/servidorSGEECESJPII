package sgeecesjpii.servidor.servicio;

import java.util.List;
import java.util.Optional;

import sgeecesjpii.servidor.modelo.Alumno;

public interface IAlumnoServicio {
	public List<Alumno> buscarTodos();

	public Optional<Alumno> buscarPorId(Integer id);
	
	public List<Alumno> buscarPorApellidos(String apellidos);
}
