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

import MsLibreria.co.ud.libreria.modelo.Categoria;
import MsLibreria.co.ud.libreria.modelo.Item;
import MsLibreria.co.ud.libreria.servicios.ItemServicio;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api
@RestController
@RequestMapping("v1/item")
public class ItemControlador {

	@Autowired
	ItemServicio itemServicio;
	
	
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ApiOperation(value = "Agrega nuevo item o editar uno existente", tags = "Items", nickname = "item", response = Item.class)
	public ResponseEntity<Boolean> agregarItem(
		    @ApiParam(value = "item", required = true) @RequestBody(required = true) Item item) {

		Boolean respuesta;
		
		respuesta = itemServicio.guardarItem(item);

		return ResponseEntity.ok(respuesta);
	}
	
	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "Obtener item por id", tags = "Items")
	public ResponseEntity<Item> consultarItem(@PathVariable String id) {

		Long idItem = Long.valueOf(id);
		Item respuesta = itemServicio.consultarItem(idItem);

		return ResponseEntity.ok(respuesta);
	}
	@ResponseBody
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	@ApiOperation(value = "Consultar todos los item", tags = "Items")
	public ResponseEntity<List<Item>> consultarItems() {

		List<Item> resultado = itemServicio.consultarItems();

		return ResponseEntity.ok(resultado);
	}
	
	@ResponseBody
	@RequestMapping(value = "/categorias/all", method = RequestMethod.GET)
	@ApiOperation(value = "Consultar todos las categorias", tags = "Categorias")
	public ResponseEntity<List<Categoria>> consultarCategorias() {

		List<Categoria> resultado = itemServicio.consultarCategorias();

		return ResponseEntity.ok(resultado);
	}
	
}
