package MsLibreria.co.ud.libreria.repositorio;

import org.springframework.data.repository.CrudRepository;

import MsLibreria.co.ud.libreria.modelo.Item;

public interface ItemRepository extends CrudRepository<Item, Long> {

}
