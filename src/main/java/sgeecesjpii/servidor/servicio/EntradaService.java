package sgeecesjpii.servidor.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sgeecesjpii.servidor.dao.IEntradaDao;
import sgeecesjpii.servidor.modelo.Entrada;

@Service
public class EntradaService  implements IEntradaServicio{
	@Autowired
	private IEntradaDao entradaDao;

	@Override
	public List<Entrada> buscarTodos() {
		return (List<Entrada>) entradaDao.findAll();
	}

	@Override
	public Optional<Entrada> buscarPorId(Integer id) {
		return entradaDao.findById(id);
	}

	@Override
	public Entrada buscarPorHash(String hash) {
		return entradaDao.findByHash(hash);
	}
	
	@Override
	public Entrada nuevaEntrada(Entrada entrada) {
		return entradaDao.save(entrada);
	}
	
}
