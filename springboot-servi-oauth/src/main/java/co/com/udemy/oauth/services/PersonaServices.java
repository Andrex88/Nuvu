package co.com.udemy.oauth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.udemy.oauth.entity.Persona;
import co.com.udemy.oauth.repository.PersonaDao;

@Service
public class PersonaServices implements IPersonaServices {

	@Autowired
	private PersonaDao personaDao;
	
	@Override
	public Persona buscarPorIdentificacion(String identificacion) {
		return personaDao.findByIdentificacion(identificacion);
	}
	
	@Override
	public Persona crear(Persona persona) throws Exception {
		if(!personaDao.existsById(persona.getIdentificacion())) {
			return personaDao.save(persona);			
		}else {
			throw new Exception("La persona con identificacion "+persona.getIdentificacion()+ " ya esta registrada");
		}
	}
	
	@Override
	public Persona actualizar(Persona persona) throws Exception {
		if(personaDao.existsById(persona.getIdentificacion())) {
			return personaDao.save(persona);		
		}else {
			throw new Exception("La persona con identificacion "+persona.getIdentificacion()+ " no existe");
		}
	}

}
