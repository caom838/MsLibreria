package MsLibreria.co.ud.libreria.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import lombok.Data;

/**
 * @author shrek
 * @version 1.0
 * @created 28-may.-2019 10:39:40 p. m.
 */
@Data
@Entity(name = "persona")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;


	@Id @GeneratedValue
	private Long id;

	private String apellidos;

	@Column(name="correo_electronico")
	private String correoElectronico;

	@Column(name="direccion_domicilio")
	private String direccionDomicilio;

	private Boolean estado;

	@Column(name="fecha_registro")
	private Date fechaRegistro;

	private String identificador;

	private String nombres;

	private String telefono;

	@Column(name="tipo_identificador")
	private String tipoIdentificador;

	//bi-directional many-to-one association to Usuario
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Usuario.class)
	@JoinColumn(name="id_usuario")
	private Usuario usuario;

	//bi-directional many-to-many association to Tarjetacredito
	@ManyToMany(mappedBy="personas", cascade = CascadeType.MERGE, fetch = FetchType.EAGER, targetEntity = TarjetaCredito.class)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<TarjetaCredito> tarjetasCredito;

	
	//bi-directional many-to-one association to Alquiler
	@OneToMany(mappedBy="persona", cascade = CascadeType.MERGE, fetch = FetchType.EAGER, targetEntity = Alquiler.class)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Alquiler> alquilers;
	
	//bi-directional many-to-one association to Venta
	@OneToMany(mappedBy="persona", cascade = CascadeType.MERGE, fetch = FetchType.EAGER, targetEntity = Venta.class)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Venta> ventas;

}//end Persona