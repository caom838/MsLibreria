package MsLibreria.co.ud.libreria.servicios;

import java.util.List;
import java.util.Optional;

import MsLibreria.co.ud.libreria.modelo.Persona;
import MsLibreria.co.ud.libreria.modelo.Venta;

public interface VentaServicio extends OperacionService {

	Venta consultar(Venta venta);
		
	Boolean registrarVenta(Venta venta);
	
	Boolean editarVenta(Venta venta);
	
	List<Venta> consultarVentas();
	
	Optional<Venta> consultarPorPersona(Persona persona);
}
