package MsLibreria.co.ud.libreria.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import MsLibreria.co.ud.libreria.modelo.Persona;
import MsLibreria.co.ud.libreria.service.IPdfService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("v1/pdf")
public class ShaPdfController {

	@Autowired
	private IPdfService pdfService;

	/**
	 * Método que expone servicio para consultar el directorio FTP y devolverá un
	 * csv con el nombre del archivo y su SHA-3
	 * 
	 * @param response
	 * @throws IOException
	 */
	@GetMapping(path = "/generate", produces = "text/csv")
	public void generateCsv(HttpServletResponse response) throws IOException {

	}

	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "Verifies the client's information", tags = "client")
	public ResponseEntity<Persona> consultarClientes(@PathVariable Long id) {

		Persona p = new Persona();

		//return ResponseEntity.ok((Persona) personaServicioPdf.getPersona(p));
		return ResponseEntity.ok(p);
	}

}
