package MsLibreria.co.ud.libreria.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

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

	//bi-directional many-to-many association to Item
		@ManyToMany
		@JoinTable(
			name="itemventa"
			, joinColumns={
				@JoinColumn(name="id_venta")
				}
			, inverseJoinColumns={
				@JoinColumn(name="id_item")
				}
			)
		private List<Item> items;

		//bi-directional many-to-one association to Mediopago
		@ManyToOne
		@JoinColumn(name="id_mediopago")
		private MedioPago mediopago;

		//bi-directional many-to-one association to Persona
		@ManyToOne
		@JoinColumn(name="id_persona")
		private Persona persona;
		

	public Double calcularTotal(){
		return 0.0;
	}
}//end Venta