package sgeecesjpii.servidor.dao;

import org.springframework.data.repository.CrudRepository;

import sgeecesjpii.servidor.modelo.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Integer>{

}
