package co.com.udemy.oauth.services;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import co.com.udemy.oauth.entity.Usuario;
import co.com.udemy.oauth.usuario.UsuarioDao;

@Service
public class UsuarioService implements IUsuarioServices, UserDetailsService {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UsuarioDao usuarioClient;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioClient.findByUsername(username);

		if (usuario == null) {
			log.error("Error en el login, no existe " + username + " en el sistema");
			throw new UsernameNotFoundException("Error en el login, no existe " + username + " en el sistema");
		}

		List<GrantedAuthority> authorities = usuario.getRoles().stream()
				.map(rol -> new SimpleGrantedAuthority(rol.getNombre()))
//				.peek(authority -> log.info(authority.getAuthority()))
				.collect(Collectors.toList());
		log.info("Usuario autenticado:" + username);
		return new User(username, usuario.getPassword(), usuario.getEnabled(), true, true, true, authorities);
	}

	@Override
	public Usuario findByUsername(String username) {
		return usuarioClient.findByUsername(username);
	}

	@Override
	public Usuario update(Usuario usuario, Long id) {
		return usuarioClient.save(usuario);
	}

}
