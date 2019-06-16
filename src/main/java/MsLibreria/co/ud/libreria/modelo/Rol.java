package MsLibreria.co.ud.libreria.modelo;

import java.io.Serializable;
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
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
//	@ManyToMany(fetch=FetchType.LAZY,cascade = CascadeType.MERGE, targetEntity = Privilegio.class)
//	@JoinColumn(name="id")
//	private List<Privilegio> privilegios;


	 @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY, targetEntity = Privilegio.class)
	 @JoinTable(name = "rolprivilegio", joinColumns = { @JoinColumn(name = "id_rol") }, 
	 			inverseJoinColumns = { @JoinColumn(name = "id_privilegio") })
	 private List<Privilegio> privilegios;

}//end Rol