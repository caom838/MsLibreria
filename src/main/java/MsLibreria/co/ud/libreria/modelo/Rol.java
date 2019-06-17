package MsLibreria.co.ud.libreria.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import lombok.Data;


/**
 * @author shrek
 * @version 1.0
 * @created 28-may.-2019 10:39:41 p. m.
 */
@Data
@Entity
@NamedQuery(name="Rol.findAll", query="SELECT r FROM Rol r")
public class Rol implements Serializable {
	private static final long serialVersionUID = 1L;

	private @Id @GeneratedValue Long id;
	
	private String descripcion;
	private boolean estado;

	//uni-directional many-to-many association to Privilegio
	 @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER, targetEntity = Privilegio.class)
	 @Fetch(value = FetchMode.SUBSELECT)
	 @JoinTable(name = "rolprivilegio", joinColumns = { @JoinColumn(name = "id_rol") }, 
	 			inverseJoinColumns = { @JoinColumn(name = "id_privilegio") })
	 private List<Privilegio> privilegios;

}//end Rol