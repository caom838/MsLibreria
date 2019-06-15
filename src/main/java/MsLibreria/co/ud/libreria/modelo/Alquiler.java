package MsLibreria.co.ud.libreria.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import lombok.Data;


/**
 * @author shrek
 * @version 1.0
 * @created 28-may.-2019 10:39:36 p. m.
 */
@Data
@Entity
@NamedQuery(name="Alquiler.findAll", query="SELECT a FROM Alquiler a")
public class Alquiler extends Operacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	private String comentarios;

	private Date fecha;
	
	/**
	 * Fecha calculada de entrega o devoluci�n de un item por alquiler
	 */
	@Column(name="fecha_entrega")
	private Date fechaEntrega;

	/**
	 * Es la fecha real que se entreg� o devolvi� el item por alquiler
	 */
	@Column(name="fecha_real_entrega")
	private Date fechaRealEntrega;

	private Double valor;

	//bi-directional many-to-one association to Mediopago
	@ManyToOne
	@JoinColumn(name="id_mediopago")
	private MedioPago mediopago;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="id_persona")
	private Persona persona;


//	@ManyToMany(fetch=FetchType.LAZY)
//	@JoinTable(
//	  name = "itemalquiler", 
//	  joinColumns = @JoinColumn(name = "id_alquiler"), 
//	  inverseJoinColumns = @JoinColumn(name = "id_item"))
//	private List<Item> items;
	
	 @Access(AccessType.PROPERTY)
	 @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Item.class)
	 @JoinTable(name = "itemalquiler", joinColumns = { @JoinColumn(name = "id_alquiler") }, 
	 			inverseJoinColumns = { @JoinColumn(name = "id_item") })
	 public List<Item> items;

	public Double calcularTotal(){
		return 0.0;
	}
}//end Alquiler