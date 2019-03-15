package sgeecesjpii.servidor.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sgeecesjpii.servidor.dao.IAlumnoDao;
import sgeecesjpii.servidor.modelo.Alumno;

@Service
public class AlumnoServicio implements IAlumnoServicio {


	@Autowired
	private IAlumnoDao alumnoDao;

	@Override
	public List<Alumno> buscarTodos() {
		return (List<Alumno>) alumnoDao.findAll();
	}

	@Override
	public Optional<Alumno> buscarPorId(Integer id) {
		return alumnoDao.findById(id);
	}
	
	@Override
	public List<Alumno> buscarPorApellidos(String apellidos) {
		return alumnoDao.findByApellidos(apellidos);
	}
	
}
