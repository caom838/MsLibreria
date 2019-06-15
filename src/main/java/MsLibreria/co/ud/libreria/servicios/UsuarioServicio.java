package MsLibreria.co.ud.libreria.servicios;

import java.util.List;

import MsLibreria.co.ud.libreria.modelo.Privilegio;
import MsLibreria.co.ud.libreria.modelo.Rol;
import MsLibreria.co.ud.libreria.modelo.Usuario;

public interface UsuarioServicio {

	Usuario get(Usuario usuario);

	Boolean autenticar(Usuario usuario);
	
	List<Rol> consultarRoles();
	
	List<Privilegio> consultarPrivilegios();
	
	List<Usuario> consultarUsuarios();
}
