package co.com.udemy.oauth.usuario;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import co.com.udemy.oauth.entity.Usuario;

@RepositoryRestResource(path = "usuario")
public interface UsuarioDao extends CrudRepository<Usuario, Long> {

	@RestResource(path = "buscarUsername")
	public Usuario findByUsername(@Param("username") String username);

	@Query("select u from Usuario u where u.username=?1")
	public Usuario obtenerPorUsername(String username);

}
