package MsLibreria.co.ud.libreria.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.Data;


/**
 * @author shrek
 * @version 1.0
 * @created 28-may.-2019 10:39:40 p. m.
 */
@Data
@Entity(name="mediopago")
@Table(name="mediopago")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class MedioPago implements Serializable {
	private static final long serialVersionUID = 1L;

	private @Id @GeneratedValue Long id;
	private boolean estado;
	private String nombre;


	
}//end MedioPago