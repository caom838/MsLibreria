package MsLibreria.co.ud.libreria.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import MsLibreria.co.ud.libreria.dto.ItemRequest;
import MsLibreria.co.ud.libreria.modelo.Categoria;
import MsLibreria.co.ud.libreria.modelo.Item;
import MsLibreria.co.ud.libreria.repositorio.CategoriaRepository;
import MsLibreria.co.ud.libreria.repositorio.ItemRepository;

@Service
public class ItemServicioImpl implements ItemServicio {


	@Autowired
	ItemRepository itemRepository;
	@Autowired
	CategoriaRepository categoriaRepository;
	
	
	@Override
	public List<Item> consultarItems() {

		return (List<Item>)itemRepository.findAll();
	}


	@Override
	public Boolean guardarItem(Item i) {

		if(itemRepository.save(i) !=null)
			return true;
		
		return false;
	}


	@Override
	public Boolean editarItem(Item i) {
		if(itemRepository.save(i) !=null)
			return true;
		return false;
	}


	@Override
	public Item consultarItem(Long id) {

		return itemRepository.findOne(id);
	}


	@Override
	public List<Categoria> consultarCategorias() {

		return (List<Categoria>)categoriaRepository.findAll();
	}
	
	
	private ItemRequest convertirItem(Item item) {
		
		ItemRequest itemE = new ItemRequest();
		itemE.setNombre(item.getNombre());
		itemE.setDescripcion(item.getDescripcion());
		itemE.setBanderaAlquiler(item.getBanderaAlquiler());
		itemE.setCodigoReferencia(item.getCodigoReferencia());
		itemE.setEstado(item.getBanderaAlquiler());;
		itemE.setPrecioAlquiler(item.getPrecioAlquiler());
		itemE.setPrecioVenta(item.getPrecioVenta());
		itemE.setStock(item.getStock());
		//itemE.setCategorias(item.getCategorias());
		
		return itemE;
	}
	

}
