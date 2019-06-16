package MsLibreria.co.ud.libreria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import MsLibreria.co.ud.libreria.dto.PersonaResponse;
import MsLibreria.co.ud.libreria.modelo.Cliente;
import MsLibreria.co.ud.libreria.servicios.PersonaServicio;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("v1/persona")
public class PersonaControlador {
	
	@Autowired
	private PersonaServicio personaServicio;
	
	
	  @ResponseBody
	  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	  @ApiOperation(value = "Verifies the client's information", tags = "Persona")
	  public ResponseEntity<PersonaResponse> consultarPersona(@PathVariable Long id) {
	    
		  Long idP = Long.valueOf(id);
		 
		  return ResponseEntity.ok((PersonaResponse)personaServicio.consultarPersona(idP));
	  }
	  
	  
	  @ResponseBody
	  @RequestMapping(value = "/all", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	  @ApiOperation(value = "Consulta todas las personas", tags = "Persona")
	  public ResponseEntity<List<PersonaResponse>> consultarPersonas() {
	    
	    return ResponseEntity.ok((List<PersonaResponse>)personaServicio.consultarPersonas());
	  }
	  
	  @ResponseBody
	  @RequestMapping(value = "/cliente/all", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	  @ApiOperation(value = "Consulta todas las clientes", tags = "Cliente")
	  public ResponseEntity<List<Cliente>> consultarClientes() {
	    
	    return ResponseEntity.ok((List<Cliente>)personaServicio.consultarClientes());
	  }
	  
	  @ResponseBody
	  @RequestMapping(value = "/cliente/{id}", method = RequestMethod.GET)
	  @ApiOperation(value = "Verifies the client's information", tags = "Persona")
	  public ResponseEntity<Cliente> consultarCliente(@PathVariable Long id) {
	    
		  Long idC = Long.valueOf(id);
		 
		  return ResponseEntity.ok((Cliente)personaServicio.consultarCliente(idC));
	  }

}
