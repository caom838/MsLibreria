package MsLibreria.co.ud.libreria.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;

import lombok.Data;


/**
 * @author shrek
 * @version 1.0
 * @created 28-may.-2019 10:39:41 p. m.
 */
@Data
@Entity
@NamedQuery(name="Rol.findAll", query="SELECT r FROM Rol r")
public class Rol implements Serializable {
	private static final long serialVersionUID = 1L;

	private @Id @GeneratedValue Long id;
	
	private String descripcion;
	private boolean estado;
	//uni-directional many-to-many association to Privilegio
	
	@ManyToMany
	@JoinColumn(name="id")
	private List<Privilegio> privilegios;



	/**
	 * 
	 * @param privilegio    privilegio
	 */
	public void agregarPrivilegio(Privilegio privilegio){

	}

	/**
	 * 
	 * @param privilegio    privilegio
	 */
	public void eliminarPrivilegio(Privilegio privilegio){

	}
}//end Rol