package MsLibreria.co.ud.libreria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import MsLibreria.co.ud.libreria.dto.AlquilerResponse;
import MsLibreria.co.ud.libreria.modelo.Alquiler;
import MsLibreria.co.ud.libreria.servicios.AlquilerServicio;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api
@RestController
@RequestMapping("/alquiler")
public class AlquilerControlador {

	@Autowired
	AlquilerServicio alquilerServicio;
		
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ApiOperation(value = "Agrega nuevo alquiler o editar uno existente", tags = "Alquiler", nickname = "Alquiler", response = Alquiler.class)
	public ResponseEntity<Boolean> agregarAlquiler(
		    @ApiParam(value = "alquiler", required = true) @RequestBody(required = true) Alquiler alquiler) {

		Boolean respuesta;
		
		respuesta = alquilerServicio.registrarAlquiler(alquiler);

		return ResponseEntity.ok(respuesta);
	}
	
	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "Obtener alquiler por id", tags = "Alquiler")
	public ResponseEntity<AlquilerResponse> consultarAlquiler(@PathVariable String id) {

		Long idA = Long.valueOf(id);
		AlquilerResponse respuesta = alquilerServicio.consultar(idA);

		return ResponseEntity.ok(respuesta);
	}
	@ResponseBody
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	@ApiOperation(value = "Consultar todos los alquileres", tags = "Alquiler")
	public ResponseEntity<List<AlquilerResponse>> consultarAlquileres() {

		List<AlquilerResponse> resultado = alquilerServicio.consultarAlquileres();

		return ResponseEntity.ok(resultado);
	}
	
	
}
