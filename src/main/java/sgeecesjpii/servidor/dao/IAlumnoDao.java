package sgeecesjpii.servidor.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import sgeecesjpii.servidor.modelo.Alumno;

public interface IAlumnoDao extends CrudRepository<Alumno, Integer>{

	List<Alumno> findByApellidos(String apellidos);
	
	
}
