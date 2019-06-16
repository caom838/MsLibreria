package MsLibreria.co.ud.libreria.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import MsLibreria.co.ud.libreria.modelo.Cliente;




public interface ClienteRepository extends  CrudRepository<Cliente, Long> {

	Cliente getById(Long id);
	
	@Query(value = "SELECT * FROM client c inner join Persona p WHERE p.doc_number = :docNumber ORDER BY datetime DESC", nativeQuery = true)
	Cliente findByDocTypeAndDocNumber(String docType, String docNumber);
	
	Cliente findByPersonaTipoIdentificadorAndIdentificador(String tipoIdentificador, String identificador);
	
	
	@Query("SELECT c , p FROM cliente c JOIN FETCH c.persona p")
	List<Cliente> findAllWithPersona();

}
