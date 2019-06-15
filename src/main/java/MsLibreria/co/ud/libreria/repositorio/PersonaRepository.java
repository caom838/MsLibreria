package MsLibreria.co.ud.libreria.repositorio;

import org.springframework.data.repository.CrudRepository;

import MsLibreria.co.ud.libreria.modelo.Persona;


public interface PersonaRepository extends  CrudRepository<Persona, Long> {

	Persona getById(Long id);
	
	Persona getByTipoIdentificadorAndIdentificador(String tipoIdentificador, String identificador);
	

}
