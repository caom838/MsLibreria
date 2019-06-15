package MsLibreria.co.ud.libreria.repositorio;

import org.springframework.data.repository.CrudRepository;

import MsLibreria.co.ud.libreria.modelo.Usuario;

public interface UsuarioRepository  extends CrudRepository<Usuario, Long> { 

}
