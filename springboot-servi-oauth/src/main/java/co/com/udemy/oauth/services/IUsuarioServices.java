package co.com.udemy.oauth.services;

import co.com.udemy.oauth.entity.Usuario;

public interface IUsuarioServices {
	public Usuario findByUsername(String username);
	public Usuario update(Usuario usuario, Long id);
}
