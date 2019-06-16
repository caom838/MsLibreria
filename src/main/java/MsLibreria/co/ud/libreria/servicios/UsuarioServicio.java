package MsLibreria.co.ud.libreria.servicios;

import java.util.List;

import MsLibreria.co.ud.libreria.dto.RolResponse;
import MsLibreria.co.ud.libreria.dto.UsuarioResponse;
import MsLibreria.co.ud.libreria.modelo.Privilegio;
import MsLibreria.co.ud.libreria.modelo.Usuario;

public interface UsuarioServicio {

	Boolean autenticar(Usuario usuario);
	
	List<RolResponse> consultarRoles();
	
	List<Privilegio> consultarPrivilegios();
	
	List<UsuarioResponse> consultarUsuarios();
	
	UsuarioResponse consultarPorId(Long id);
	
	Boolean guardarUsuario(Usuario usuario);
	
	RolResponse consultarRol(Long id);
}
