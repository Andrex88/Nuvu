package co.com.udemy.oauth.services;

import co.com.udemy.oauth.entity.Persona;

public interface IPersonaServices {
	public Persona buscarPorIdentificacion(String identificacion);

	public Persona crear(Persona persona) throws Exception;

	public Persona actualizar(Persona persona) throws Exception;
}
