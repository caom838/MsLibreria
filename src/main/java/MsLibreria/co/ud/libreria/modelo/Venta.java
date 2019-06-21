package MsLibreria.co.ud.libreria.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import lombok.Data;

/**
 * @author shrek
 * @version 1.0
 * @created 28-may.-2019 10:39:42 p. m.
 */
@Data
@Entity
@NamedQuery(name="Venta.findAll", query="SELECT v FROM Venta v")
public class Venta extends Operacion implements Serializable {
	private static final long serialVersionUID = 1L;

	private @Id @GeneratedValue Long id;

	private String comentarios;
	private Date fecha;
	private Double valor;
	
	//bi-directional many-to-many association to Item
		 @Access(AccessType.PROPERTY)
		 @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER, targetEntity = Item.class)
		 @JoinTable(name = "itemventa", joinColumns = { @JoinColumn(name = "id_venta") }, 
		 			inverseJoinColumns = { @JoinColumn(name = "id_item") })
		private List<Item> items;
		

		//bi-directional many-to-one association to Mediopago
		@ManyToOne(cascade=CascadeType.MERGE)
		@JoinColumn(name="id_mediopago")
		private MedioPago medioPago;

		//bi-directional many-to-one association to Persona
		@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Persona.class)
		@JoinColumn(name="id_persona")
		private Persona persona;
		


}//end Venta