package MsLibreria.co.ud.libreria.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;

import lombok.Data;

/**
 * @author shrek
 * @version 1.0
 * @created 28-may.-2019 10:39:37 p. m.
 */
@Data
@Entity
@NamedQuery(name="Item.findAll", query="SELECT i FROM Item i")
public class Item implements Serializable {
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue
	private Long id;

	@Column(name="bandera_alquiler", nullable=false)
	private Boolean banderaAlquiler;

	@Column(name="codigo_referencia")
	private String codigoReferencia;

	private String descripcion;

	private Boolean estado;

	private String nombre;

	@Column(name="precio_alquiler")
	private BigDecimal precioAlquiler;

	@Column(name="precio_venta")
	private BigDecimal precioVenta;

	private Integer stock;


	//bi-directional many-to-many association to Categoria
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Categoria.class)
	@JoinTable(
		name="itemcategoria"
		, joinColumns={
			@JoinColumn(name="id_item")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_categoria")
			}
		)
	private List<Categoria> categorias;


//	@ManyToMany(mappedBy = "items")
//	List<Alquiler> alquileres;
}//end Item