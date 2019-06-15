package MsLibreria.co.ud.libreria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import MsLibreria.co.ud.libreria.modelo.Item;
import MsLibreria.co.ud.libreria.servicios.ItemServicio;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api
@RestController
public class ItemControlador {

	@Autowired
	ItemServicio itemServicio;
	
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ApiOperation(value = "Agrega nuevo item", tags = "Items")
	public ResponseEntity<Boolean> agregarItem(@PathVariable Item item) {

		Boolean respuesta;
		respuesta = itemServicio.guardarItem(item);

		return ResponseEntity.ok(respuesta);
	}
	
	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "Agrega nuevo item", tags = "Items")
	public ResponseEntity<Item> consultarItem(@PathVariable String strItem) {

		Long idItem = Long.parseLong(strItem);
		Item respuesta = itemServicio.consultarItem(idItem);

		return ResponseEntity.ok(respuesta);
	}
	@ResponseBody
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	@ApiOperation(value = "Consultar todos los item", tags = "Items")
	public ResponseEntity<List<Item>> consultarItems() {

		Boolean respuesta;
		List<Item> resultado = itemServicio.consultarItems();

		return ResponseEntity.ok(resultado);
	}
	
}
