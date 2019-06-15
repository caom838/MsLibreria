package MsLibreria.co.ud.libreria.repositorio;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import MsLibreria.co.ud.libreria.modelo.Persona;
import MsLibreria.co.ud.libreria.modelo.Venta;

public interface VentaRepository extends CrudRepository<Venta, Long> {
	
	Optional<Venta> findByPersona(Persona persona);

}
