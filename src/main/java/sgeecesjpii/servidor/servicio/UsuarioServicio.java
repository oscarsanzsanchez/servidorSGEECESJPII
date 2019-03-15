package sgeecesjpii.servidor.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sgeecesjpii.servidor.dao.IUsuarioDao;
import sgeecesjpii.servidor.modelo.Usuario;

@Service
public class UsuarioServicio implements IUsuarioServicio {

	@Autowired
	private IUsuarioDao usuarioDao;
	
	@Override
	public List<Usuario> buscarTodos() {
		// TODO Auto-generated method stub
		return (List<Usuario>) usuarioDao.findAll();
	}

	@Override
	public Optional<Usuario> buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return usuarioDao.findById(id);
	}

}
