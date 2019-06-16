package MsLibreria.co.ud.libreria.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import MsLibreria.co.ud.libreria.dto.RolResponse;
import MsLibreria.co.ud.libreria.dto.UsuarioResponse;
import MsLibreria.co.ud.libreria.modelo.Privilegio;
import MsLibreria.co.ud.libreria.modelo.Rol;
import MsLibreria.co.ud.libreria.modelo.Usuario;
import MsLibreria.co.ud.libreria.repositorio.RolRepository;
import MsLibreria.co.ud.libreria.repositorio.UsuarioRepository;

@Service
public class UsuarioServicioImpl implements UsuarioServicio{

	@Autowired 
	UsuarioRepository usuarioRepository;
	
	@Autowired 
	RolRepository rolRepository;

	@Override
	public Boolean autenticar(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RolResponse> consultarRoles() {
		List<Rol> rs = (List<Rol>)rolRepository.findAllAndPrivilegios();
		List<RolResponse> pr = new ArrayList<RolResponse>();
		for(Rol r :rs) {
			pr.add(convertirRol(r));
		}
		return pr;	
	}

	@Override
	public List<Privilegio> consultarPrivilegios() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UsuarioResponse> consultarUsuarios() {
		
		List<Usuario> resultado = (List<Usuario>)usuarioRepository.findAll();
		List<UsuarioResponse> usuarios = new ArrayList<UsuarioResponse>();
		for(Usuario u: resultado) {
			UsuarioResponse ur=	convertirUsuario(u);
			usuarios.add(ur);
		}
		return usuarios;
	}

	@Override
	public UsuarioResponse consultarPorId(Long id) {
		Usuario respuesta= usuarioRepository.findOne(id);
		return convertirUsuario(respuesta);
	
	}
	
	@Override
	public Boolean guardarUsuario(Usuario usuario) {
		if(usuarioRepository.save(usuario) != null)
			return true;
		return false;
		
	}
	
	public RolResponse consultarRol(Long id)
	{
		return convertirRol(rolRepository.findById(id));
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
	
	private RolResponse convertirRol(Rol rol) {
		RolResponse rr = new RolResponse();
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
		return rr;
	}
}
