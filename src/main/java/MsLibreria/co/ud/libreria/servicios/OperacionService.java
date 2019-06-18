package MsLibreria.co.ud.libreria.servicios;

import java.util.List;

import MsLibreria.co.ud.libreria.modelo.Item;

public interface OperacionService {

	Double calcularTotal(List<Item> items);

}
