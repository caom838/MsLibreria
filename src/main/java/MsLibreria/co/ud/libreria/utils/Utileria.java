package MsLibreria.co.ud.libreria.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import MsLibreria.co.ud.libreria.dto.AlquilerResponse;
import MsLibreria.co.ud.libreria.dto.CategoriaDTO;
import MsLibreria.co.ud.libreria.dto.ItemRequest;
import MsLibreria.co.ud.libreria.dto.PersonaResponse;
import MsLibreria.co.ud.libreria.dto.RolResponse;
import MsLibreria.co.ud.libreria.dto.UsuarioResponse;
import MsLibreria.co.ud.libreria.modelo.Alquiler;
import MsLibreria.co.ud.libreria.modelo.Categoria;
import MsLibreria.co.ud.libreria.modelo.Item;
import MsLibreria.co.ud.libreria.modelo.Persona;
import MsLibreria.co.ud.libreria.modelo.Privilegio;
import MsLibreria.co.ud.libreria.modelo.Rol;
import MsLibreria.co.ud.libreria.modelo.Usuario;

public class Utileria {
	
	
	public static UsuarioResponse convertirUsuario(Usuario usuario) {
		UsuarioResponse ur = new UsuarioResponse();
		if(Objects.nonNull(usuario))
		{
		ur.setId(usuario.getId());
		ur.setNombreUsuario(usuario.getNombreUsuario());
		ur.setContrasena(usuario.getContrasena());
		ur.setEstado(usuario.getEstado());
		RolResponse rr = new RolResponse();
		rr.setId(usuario.getRol().getId());
		rr.setDescripcion(usuario.getRol().getDescripcion());
		rr.setEstado(usuario.getRol().isEstado());
		ur.setRol(rr);
		}
		return ur;
	}
	
	public static RolResponse convertirRol(Rol rol) {
		RolResponse rr = new RolResponse();
		if(Objects.nonNull(rol))
		{
		rr.setId(rol.getId());
		rr.setDescripcion(rol.getDescripcion());
		rr.setEstado(rol.isEstado());
		
		List<Privilegio> prs  = new ArrayList<Privilegio>();
		for(Privilegio pr : rol.getPrivilegios())
		{
			Privilegio p = new Privilegio();
			p.setId(pr.getId());
			p.setDescripcion(pr.getDescripcion());
			prs.add(p);
		}
		
		rr.setPrivilegios(prs);
		}
		return rr;
	}

	public static AlquilerResponse convertirAlquiler(Alquiler alquiler)
	{
		AlquilerResponse ar = new AlquilerResponse();
		if(Objects.nonNull(alquiler))
		{
		ar.setComentarios(alquiler.getComentarios());
		ar.setFechaEntrega(alquiler.getFechaEntrega());
		ar.setFechaRealEntrega(alquiler.getFechaRealEntrega());
		ar.setId(alquiler.getId());
		ar.setValor(alquiler.getValor());
		
		ar.setPersona(convertirPersona(alquiler.getPersona()));
		
		List<ItemRequest> lc = new ArrayList<>();
		for(Item c : alquiler.getItems()) {
			lc.add(convertirItem(c));
		}
		ar.setItems(lc);
		}
		
		return ar;

	}
	
	public static ItemRequest convertirItem(Item item) {
		
		ItemRequest itemE = new ItemRequest();
		if(Objects.nonNull(item))
		{
		itemE.setNombre(item.getNombre());
		itemE.setDescripcion(item.getDescripcion());
		itemE.setBanderaAlquiler(item.getBanderaAlquiler());
		itemE.setCodigoReferencia(item.getCodigoReferencia());
		itemE.setEstado(item.getBanderaAlquiler());
		itemE.setPrecioAlquiler(item.getPrecioAlquiler());
		itemE.setPrecioVenta(item.getPrecioVenta());
		itemE.setStock(item.getStock());
		
		List<CategoriaDTO> lc = new ArrayList<>();
		for(Categoria c : item.getCategorias()) {
			lc.add(convertirCategoria(c));
		}
		itemE.setCategorias(lc);
		}
		return itemE;
	}
	
	public static CategoriaDTO convertirCategoria(Categoria c)
	{
		CategoriaDTO cdto = new CategoriaDTO();
		if(Objects.nonNull(c))
		{
		cdto.setId(c.getId());
		cdto.setNombre(c.getNombre());
		}
		return cdto;
	}
	
	
	public static PersonaResponse convertirPersona(Persona persona)
	{
		PersonaResponse pr = new PersonaResponse();
		if(Objects.nonNull(persona))
		{
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
		}
		return pr;
	} 
	
}
