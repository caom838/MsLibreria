package MsLibreria.co.ud.libreria.repositorio;

import org.springframework.data.repository.CrudRepository;

import MsLibreria.co.ud.libreria.modelo.Persona;


public interface PersonaRepository extends  CrudRepository<Persona, Long> {

	Persona getById(Long id);
	
	Persona findByTipoIdentificadorAndIdentificador(String tipoIdentificador, String identificador);
	
//	@Query("SELECT p, u , r FROM Persona p JOIN FETCH p.usuario u JOIN FETCH u.rol r")
//	List<Persona> getAllPersonasUsuario();
	
	

}
