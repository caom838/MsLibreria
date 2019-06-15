package MsLibreria.co.ud.libreria.modelo;

import java.util.Date;
import java.util.List;

import lombok.Data;


/**
 * @author shrek
 * @version 1.0
 * @created 28-may.-2019 10:39:40 p. m.
 */
@Data
public abstract class Operacion {

	private String comentarios;
	private Date fecha;
	private List<Item> items;
	private MedioPago medioPago;
	private Persona persona;
	private Double valor;


	public Double calcularTotal(){
		return 0.0;
	}
}//end Operacion