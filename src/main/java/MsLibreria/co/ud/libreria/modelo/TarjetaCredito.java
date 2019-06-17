package MsLibreria.co.ud.libreria.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;


/**
 * @author shrek
 * @version 1.0
 * @created 28-may.-2019 10:39:41 p. m.
 */
@Data
@Entity(name="tarjetacredito")
@Table(name="tarjetacredito")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class TarjetaCredito extends MedioPago implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private @Id @GeneratedValue Long id;

	@Column(name="codigo_cvv")
	private String codigoCvv;

	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss.SSS")
	@Column(name="fecha_expiracion")
	private Date fechaExpiracion;

	@Column(name="numero_tarjeta")
	private String numeroTarjeta;

	@Column(name="tarjeta_habiente")
	private String tarjetaHabiente;

	//bi-directional many-to-one association to Mediopago
		@ManyToOne
		@JoinColumn(name="id_mediopago")
		private MedioPago mediopago;

	//bi-directional many-to-many association to Persona
	@ManyToMany
	@JoinTable(
		name="tarjetacreditopersona"
		, joinColumns={
			@JoinColumn(name="id_tarjeta")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_persona")
			}
		)
	private List<Persona> personas;
	

	public boolean esValida(){
		return false;
	}

	public String getFechaExpiracion(){
		return "";
	}

	public String getNumeroTarjeta(){
		return "";
	}
	
	@Override
	public String getNombre() {
		return super.getNombre() + this.getNombre();
	}
}//end TarjetaCredito