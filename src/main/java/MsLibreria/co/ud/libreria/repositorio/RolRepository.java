package MsLibreria.co.ud.libreria.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import MsLibreria.co.ud.libreria.modelo.Rol;

public interface RolRepository  extends CrudRepository<Rol, Long> { 

	
	@Query("SELECT r, p FROM Rol r JOIN FETCH r.privilegios p WHERE r.id = :id")
	Rol findById(@Param("id") Long id);
	
	@Query("SELECT r , p FROM Rol r JOIN FETCH r.privilegios p")
	List<Rol> findAllAndPrivilegios();
}
