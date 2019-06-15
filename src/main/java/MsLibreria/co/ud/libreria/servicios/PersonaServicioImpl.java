package MsLibreria.co.ud.libreria.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import MsLibreria.co.ud.libreria.modelo.Persona;
import MsLibreria.co.ud.libreria.repositorio.PersonaRepository;

@Service
public class PersonaServicioImpl implements PersonaServicio{

	@Autowired
	PersonaRepository personaRepository;
	
	@Override
	public Persona getPersona(Persona persona) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Persona getCliente(Persona cliente) {
	
		//personaRepository.getByCliente(cliente);
		return null;
	}

	@Override
	public Persona getEmpleado(Persona persona) {
		personaRepository.getById(persona.getId());
		return null;
	}
	
	@Override
	public List<Persona> consultarPersonas()
	{
		return (List<Persona>)personaRepository.findAll();
	}
	
	public Boolean guardarPersona(Persona persona)
	{
		Persona p = personaRepository.save(persona);
		return p!=null?true:false;
	}

}
