package co.com.udemy.oauth.security.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationEventPublisher;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import co.com.udemy.oauth.entity.Usuario;
import co.com.udemy.oauth.services.IUsuarioServices;

@Component
public class AuthenticationSuccessErrorHandler implements AuthenticationEventPublisher {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IUsuarioServices usuarioServices;
	
	@Value("${config.security.oauth.client.id}")
	private String idClient;

	@Override
	public void publishAuthenticationSuccess(Authentication authentication) {
		
		if(authentication.getAuthorities().size() == 0){
		    return;
		}

		Usuario usuario = usuarioServices.findByUsername(authentication.getName());
		String mensaje = "Success login: " + usuario.getUsername();
		log.info(mensaje);
		if (usuario.getIntentos() == null || usuario.getIntentos() >0) {
			usuario.setIntentos(0);
		}
		usuarioServices.update(usuario, usuario.getId());
		
	}

	@Override
	public void publishAuthenticationFailure(AuthenticationException exception, Authentication authentication) {
		String mensaje = "Error en el login: " + exception.getMessage();
		log.error(mensaje);

		try {
			Usuario usuario = usuarioServices.findByUsername(authentication.getName());
			if (usuario.getIntentos() == null) {
				usuario.setIntentos(0);
			}
			
			log.info(String.format("El intento actual es %d del usuario %s es de: ",usuario.getIntentos()+1, authentication.getName()));
			usuario.setIntentos(usuario.getIntentos() + 1);
			
			if (usuario.getIntentos() >= 3) {
				usuario.setEnabled(false);
				log.error(String.format("El usuario %s fue des-habilitado en el sistema", authentication.getName()));
			}
			
			usuarioServices.update(usuario, usuario.getId());
			
		} catch (Exception e) {
			log.error(String.format("El usuario %s no existe en el sistema", authentication.getName()));
		}
	}

}
