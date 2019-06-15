package MsLibreria.co.ud.libreria.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
