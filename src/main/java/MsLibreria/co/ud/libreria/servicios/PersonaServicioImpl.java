package MsLibreria.co.ud.libreria.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import MsLibreria.co.ud.libreria.dto.PersonaResponse;
import MsLibreria.co.ud.libreria.dto.RolResponse;
import MsLibreria.co.ud.libreria.dto.UsuarioResponse;
import MsLibreria.co.ud.libreria.modelo.Cliente;
import MsLibreria.co.ud.libreria.modelo.Persona;
import MsLibreria.co.ud.libreria.modelo.Usuario;
import MsLibreria.co.ud.libreria.repositorio.ClienteRepository;
import MsLibreria.co.ud.libreria.repositorio.PersonaRepository;

@Service
public class PersonaServicioImpl implements PersonaServicio{

	@Autowired
	PersonaRepository personaRepository;
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Override
	public PersonaResponse consultarPersona(Long id) {
		return convertirPersona(personaRepository.findOne(id));
	}

	@Override
	public Cliente consultarCliente(Long id) {
	
		return clienteRepository.findOne(id);
		 
	}
	
	@Override
	public List<Cliente> consultarClientes()
	{
		List<Cliente> respuesta = (List<Cliente>)clienteRepository.findAllWithPersona();
//		List<PersonaResponse> pr = new ArrayList<>();
//		for(Persona p : respuesta)
//		{
//			pr.add(convertirPersona(p));
//		}
		
		return respuesta;
	}

	@Override
	public PersonaResponse getEmpleado(Persona persona) {
		return convertirPersona(personaRepository.getById(persona.getId()));
		 
	}
	
	@Override
	public List<PersonaResponse> consultarPersonas()
	{
		List<Persona> respuesta = (List<Persona>)personaRepository.findAll();
		List<PersonaResponse> pr = new ArrayList<>();
		for(Persona p : respuesta)
		{
			pr.add(convertirPersona(p));
		}
		
		return pr;
	}
	
	public Boolean guardarPersona(Persona persona)
	{
		Persona p = personaRepository.save(persona);
		return p!=null?true:false;
	}

	
	private PersonaResponse convertirPersona(Persona persona)
	{
		PersonaResponse pr = new PersonaResponse();
		
		pr.setId(persona.getId());
		
		pr.setApellidos(persona.getApellidos());
		pr.setCorreoElectronico(persona.getCorreoElectronico());
		pr.setDireccionDomicilio(persona.getDireccionDomicilio());
		pr.setEstado(persona.getEstado());
		pr.setFechaRegistro(persona.getFechaRegistro());
		pr.setIdentificador(persona.getIdentificador());
		pr.setNombres(persona.getNombres());
		pr.setTelefono(persona.getTelefono());
		pr.setTipoIdentificador(persona.getTipoIdentificador());
		pr.setUsuario(convertirUsuario(persona.getUsuario()));
		
		return pr;
	} 
	
	private UsuarioResponse convertirUsuario(Usuario usuario) {
		UsuarioResponse ur = new UsuarioResponse();
		ur.setId(usuario.getId());
		ur.setNombreUsuario(usuario.getNombreUsuario());
		ur.setContrasena(usuario.getContrasena());
		ur.setEstado(usuario.getEstado());
		RolResponse rr = new RolResponse();
		rr.setId(usuario.getRol().getId());
		rr.setDescripcion(usuario.getRol().getDescripcion());
		rr.setEstado(usuario.getRol().isEstado());
		ur.setRol(rr);
		return ur;
	}
}
