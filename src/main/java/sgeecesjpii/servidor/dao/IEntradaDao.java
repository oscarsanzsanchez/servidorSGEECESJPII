package sgeecesjpii.servidor.dao;

import org.springframework.data.repository.CrudRepository;

import sgeecesjpii.servidor.modelo.Entrada;

public interface IEntradaDao extends CrudRepository<Entrada, Integer> {


	
	public Entrada findByHash(String hash);
	
}
