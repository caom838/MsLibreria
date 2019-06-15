package MsLibreria.co.ud.libreria.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import MsLibreria.co.ud.libreria.controladores.request.CategoriaDTO;
import MsLibreria.co.ud.libreria.controladores.request.ItemRequest;
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
	@ApiOperation(value = "Agrega nuevo item", tags = "Items", nickname = "item", response = Item.class)
	public ResponseEntity<Boolean> agregarItem(
		    @ApiParam(value = "item", required = true) @RequestBody(required = true) Item item) {

		Boolean respuesta;
//		Item itemE = new Item();
//		itemE.setNombre(item.getNombre());
//		itemE.setDescripcion(item.getDescripcion());
//		itemE.setBanderaAlquiler(item.getBanderaAlquiler());
//		itemE.setCodigoReferencia(item.getCodigoReferencia());
//		itemE.setEstado(item.getBanderaAlquiler());;
//		itemE.setPrecioAlquiler(item.getPrecioAlquiler());
//		itemE.setPrecioVenta(item.getPrecioVenta());
//		itemE.setStock(item.getStock());
		
		
		//itemE.setcategorias(item.getBanderaAlquiler());;	
				
		respuesta = itemServicio.guardarItem(item);

		return ResponseEntity.ok(respuesta);
	}
	
	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "Agrega nuevo item", tags = "Items")
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
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	@ApiOperation(value = "Consultar todos las categorias", tags = "Categorias")
	public ResponseEntity<List<Item>> consultarCategorias() {

		List<Item> resultado = itemServicio.consultarItems();

		return ResponseEntity.ok(resultado);
	}
	
}
