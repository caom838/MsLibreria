package MsLibreria.co.ud.libreria.servicios;

import java.util.List;

import MsLibreria.co.ud.libreria.modelo.Categoria;
import MsLibreria.co.ud.libreria.modelo.Item;

public interface ItemServicio {

	List<Item> consultarItems();
	
	Boolean guardarItem(Item i);
	Boolean editarItem(Item i);
	Item consultarItem(Long id);
	
	List<Categoria> consultarCategorias();
	
	
}
