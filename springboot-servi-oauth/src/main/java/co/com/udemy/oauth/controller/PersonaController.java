package co.com.udemy.oauth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import co.com.udemy.oauth.entity.Persona;
import co.com.udemy.oauth.services.IPersonaServices;

@RestController
@RequestMapping(path = "Persona")
public class PersonaController {

	@Autowired
	public IPersonaServices personaService;

	@GetMapping("/ver/{id}")
	public Persona detaller(@PathVariable String id) {
		try {
			return personaService.buscarPorIdentificacion(id);
		} catch (Exception ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
		}
	}
	
	@PostMapping("/crear")
	public ResponseEntity<?> crear(@RequestBody Persona persona) {
		try {
			return new ResponseEntity<Persona>(personaService.crear(persona),HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<String>(ex.getMessage() ,HttpStatus.CONFLICT);
		}
	}
	
	@PutMapping("/actualizar")
	public ResponseEntity<?> actualizar(@RequestBody Persona persona) {
		try {
			return new ResponseEntity<Persona>(personaService.actualizar(persona),HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<String>(ex.getMessage() ,HttpStatus.NOT_FOUND);
		}
	}
	

}
