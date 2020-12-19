package co.com.udemy.oauth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import co.com.udemy.oauth.entity.Persona;

@RepositoryRestResource(path = "usuario")
public interface PersonaDao extends JpaRepository<Persona, String> {
	public Persona findByIdentificacion(String identificacion);
}
