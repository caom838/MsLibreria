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

import MsLibreria.co.ud.libreria.modelo.Alquiler;
import MsLibreria.co.ud.libreria.modelo.Item;
import MsLibreria.co.ud.libreria.modelo.Venta;
import MsLibreria.co.ud.libreria.servicios.VentaServicio;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api
@RestController
@RequestMapping("/venta")
public class VentaControlador {

	
	@Autowired
	VentaServicio ventaServicio;
		
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ApiOperation(value = "Agrega nuevo venta o editar uno existente", tags = "Venta", nickname = "venta", response = Venta.class)
	public ResponseEntity<Boolean> agregarItem(
		    @ApiParam(value = "venta", required = true) @RequestBody(required = true) Venta venta) {

		Boolean respuesta;
		
		respuesta = ventaServicio.registrarVenta(venta);

		return ResponseEntity.ok(respuesta);
	}
	
	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "Obtener Venta por id", tags = "Venta")
	public ResponseEntity<Venta> consultarVenta(@PathVariable String id) {

		Long idA = Long.valueOf(id);
		Venta respuesta = ventaServicio.consultar(idA);

		return ResponseEntity.ok(respuesta);
	}
	@ResponseBody
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	@ApiOperation(value = "Consultar todos los item", tags = "Venta")
	public ResponseEntity<List<Venta>> consultarItems() {

		List<Venta> resultado = ventaServicio.consultarVentas();

		return ResponseEntity.ok(resultado);
	}
}
