package sgeecesjpii.servidor.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sgeecesjpii.servidor.dao.IRolDao;
import sgeecesjpii.servidor.modelo.Rol;

@Service
public class RolServicio implements IRolServicio {

	@Autowired
	private IRolDao rolDao;

	@Override
	public List<Rol> buscarTodos() {
		return (List<Rol>) rolDao.findAll();
	}

	@Override
	public Optional<Rol> buscarPorId(Integer id) {
		return rolDao.findById(id);
	}
	
}
