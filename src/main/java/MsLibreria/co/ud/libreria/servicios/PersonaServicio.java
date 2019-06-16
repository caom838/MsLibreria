package MsLibreria.co.ud.libreria.servicios;

import java.util.List;

import MsLibreria.co.ud.libreria.dto.PersonaResponse;
import MsLibreria.co.ud.libreria.modelo.Cliente;
import MsLibreria.co.ud.libreria.modelo.Persona;

public interface PersonaServicio {

	PersonaResponse consultarPersona(Long id);
			
	PersonaResponse getEmpleado(Persona empleado);
	List<PersonaResponse> consultarPersonas();

	Cliente consultarCliente(Long id);

	List<Cliente> consultarClientes();
}
