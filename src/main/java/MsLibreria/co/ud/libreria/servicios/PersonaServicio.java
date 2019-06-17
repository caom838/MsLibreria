package MsLibreria.co.ud.libreria.servicios;

import java.util.List;

import MsLibreria.co.ud.libreria.dto.PersonaResponse;
import MsLibreria.co.ud.libreria.modelo.Cliente;
import MsLibreria.co.ud.libreria.modelo.Empleado;
import MsLibreria.co.ud.libreria.modelo.Persona;

public interface PersonaServicio {

	PersonaResponse consultarPersona(Long id);
	PersonaResponse consultarEmpleado(Long id);
	Cliente consultarCliente(Long id);
	
	List<PersonaResponse> consultarPersonas();
	List<Cliente> consultarClientes();
	List<Empleado> consultarEmpleados();
	
	Boolean guardarPersona(Persona persona);
	Boolean guardarCliente(Cliente cliente);
	Boolean guardarEmpleado(Empleado empleado);
	

}
