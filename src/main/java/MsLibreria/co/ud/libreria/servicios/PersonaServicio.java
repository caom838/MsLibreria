package MsLibreria.co.ud.libreria.servicios;

import java.util.List;

import MsLibreria.co.ud.libreria.modelo.Persona;

public interface PersonaServicio {

	Persona getPersona(Persona persona);
	Persona getCliente(Persona cliente);
	Persona getEmpleado(Persona empleado);
	List<Persona> consultarPersonas();
}
