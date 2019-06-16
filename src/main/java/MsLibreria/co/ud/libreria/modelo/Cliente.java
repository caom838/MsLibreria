package MsLibreria.co.ud.libreria.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

/**
 * @author shrek
 * @version 1.0
 * @created 28-may.-2019 10:39:36 p. m.
 */
@Data
@Entity(name = "cliente")
public class Cliente extends Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(name="direccion_facturacion")
	private String direccionFacturacion;

	//bi-directional many-to-one association to Persona
	@OneToOne
	@JoinColumn(name="id_persona")
	private Persona persona;

}//end Cliente