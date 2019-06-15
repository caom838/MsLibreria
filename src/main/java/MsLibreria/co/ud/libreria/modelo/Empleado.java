package MsLibreria.co.ud.libreria.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;


/**
 * @author shrek
 * @version 1.0
 * @created 28-may.-2019 10:39:37 p. m.
 */
@Data
@Entity(name = "empleado")
public class Empleado  extends Persona implements Serializable {
private static final long serialVersionUID = 1L;

	private @Id @GeneratedValue Long id;
	
	@Column(name="es_administrador")
	private Boolean esAdministrador;

	@Column(name="fecha_ingreso")
	private Date fechaIngreso;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="id_persona")
	private Persona persona;


	public void finalize() throws Throwable {
		super.finalize();
	}
	public Empleado(){

	}
}//end Empleado