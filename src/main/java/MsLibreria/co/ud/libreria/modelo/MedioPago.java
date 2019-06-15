package MsLibreria.co.ud.libreria.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


/**
 * @author shrek
 * @version 1.0
 * @created 28-may.-2019 10:39:40 p. m.
 */
@Entity
public class MedioPago implements Serializable {
	private static final long serialVersionUID = 1L;

	private @Id @GeneratedValue Long id;
	private boolean estado;
	private String nombre;

	/**
	 * Obtiene el nombre compuesto del medio de pago
	 * @return String
	 */
	public String getNombre(){
		return this.nombre;
	}
	
}//end MedioPago