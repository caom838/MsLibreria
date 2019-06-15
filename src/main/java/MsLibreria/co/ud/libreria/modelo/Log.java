package MsLibreria.co.ud.libreria.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

import lombok.Data;

/**
 * @author shrek
 * @version 1.0
 * @created 28-may.-2019 10:39:38 p. m.
 */
@Data
@Entity
@NamedQuery(name="Log.findAll", query="SELECT l FROM Log l")
public class Log implements Serializable {
	private static final long serialVersionUID = 1L;

	private @Id @GeneratedValue Long id;
	private String descripcion;
	private Date fecha;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;


	public void finalize() throws Throwable {

	}
	public Log(){

	}

	/**
	 * 
	 * @param usuario
	 * @param fechaInicio
	 * @param fechaFin
	 */
	public List<Log> consultarFiltro(Usuario usuario, Date fechaInicio, Date fechaFin){
		return null;
	}
}//end Log