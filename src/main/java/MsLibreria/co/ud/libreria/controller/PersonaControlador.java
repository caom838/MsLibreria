package MsLibreria.co.ud.libreria.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import MsLibreria.co.ud.libreria.modelo.Persona;
import MsLibreria.co.ud.libreria.servicios.PersonaServicio;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("v1/persona")
public class PersonaControlador {
	
	@Autowired
	private PersonaServicio personaServicio;
	
	@GetMapping(path="/index")
	public String index(HttpServletResponse response ) {
		return "persona";
	}
	
//	@GetMapping("/persona")
//	public ModelAndView displayArticle(Map<String, Object> model) {
//	 
//	    List<Persona> articles = IntStream.range(0, 10)
//	      .mapToObj(i -> personaServicio.consultarPersonas().get(i))
//	      .collect(Collectors.toList());
//	 
//	    model.put("personas", articles);
//	 
//	    return new ModelAndView("index", model);
//	}
	
	  @ResponseBody
	  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	  @ApiOperation(value = "Verifies the client's information", tags = "client")
	  public ResponseEntity<Persona> consultarClientes(@PathVariable Long id) {
	    
	    Persona p = new Persona();
	    
	    return ResponseEntity.ok((Persona)personaServicio.getPersona(p));
	  }
	  
	  
	  @ResponseBody
	  @RequestMapping(value = "/all", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	  @ApiOperation(value = "Verifies the client's information", tags = "client")
	  public ResponseEntity<List<Persona>> consultarClientes() {
	    
	    return ResponseEntity.ok((List<Persona>)personaServicio.consultarPersonas());
	  }

}
