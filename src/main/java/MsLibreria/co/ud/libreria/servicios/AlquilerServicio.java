package MsLibreria.co.ud.libreria.servicios;

import java.util.List;

import MsLibreria.co.ud.libreria.modelo.Alquiler;

public interface AlquilerServicio extends OperacionService {

		
	Alquiler consultar(Long id);
	
	Boolean registrarAlquiler(Alquiler alquiler);
	
	Boolean editarAlquiler(Alquiler alquiler);
	
	List<Alquiler> consultarAlquileres();
	
}
