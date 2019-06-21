package MsLibreria.co.ud.libreria.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import MsLibreria.co.ud.libreria.dto.PersonaResponse;
import MsLibreria.co.ud.libreria.modelo.Cliente;
import MsLibreria.co.ud.libreria.modelo.Empleado;
import MsLibreria.co.ud.libreria.modelo.Persona;
import MsLibreria.co.ud.libreria.repositorio.ClienteRepository;
import MsLibreria.co.ud.libreria.repositorio.PersonaRepository;
import MsLibreria.co.ud.libreria.utils.Utileria;

@Service
public class PersonaServicioImpl implements PersonaServicio{

	@Autowired
	PersonaRepository personaRepository;
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Override
	public PersonaResponse consultarPersona(Long id) {
		return Utileria.convertirPersona(personaRepository.findOne(id));
	}

	@Override
	public Cliente consultarCliente(Long id) {
	
		return clienteRepository.findOne(id);
		 
	}
	
	@Override
	public List<Cliente> consultarClientes()
	{
		List<Cliente> respuesta = (List<Cliente>)clienteRepository.findAllWithPersona();
		
		return respuesta;
	}

	@Override
	public PersonaResponse consultarEmpleado(Long id) {
		return Utileria.convertirPersona(personaRepository.getById(id));
		 
	}
	
	@Override
	public List<PersonaResponse> consultarPersonas()
	{
		List<Persona> respuesta = (List<Persona>)personaRepository.findAll();
		List<PersonaResponse> pr = new ArrayList<>();
		for(Persona p : respuesta)
		{
			pr.add(Utileria.convertirPersona(p));
		}
		
		return pr;
	}
	
	public Boolean guardarPersona(Persona persona)
	{
		Persona p = personaRepository.save(persona);
		return p!=null?true:false;
	}

	
	

	@Override
	public Boolean guardarCliente(Cliente cliente) {
		Persona p = clienteRepository.save(cliente);
		return p!=null?true:false;
	}

	@Override
	public Boolean guardarEmpleado(Empleado empleado) {
		Persona p = personaRepository.save(empleado);
		return p!=null?true:false;
	}

	@Override
	public List<Empleado> consultarEmpleados() {
		// TODO Auto-generated method stub
		return null;
	}
}
