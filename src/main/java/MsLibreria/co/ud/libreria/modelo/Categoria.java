package MsLibreria.co.ud.libreria.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;

import lombok.Data;

/**
 * @author shrek
 * @version 1.0
 * @created 28-may.-2019 10:39:36 p. m.
 */
@Data
@Entity
@NamedQuery(name="Categoria.findAll", query="SELECT c FROM Categoria c")
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;

	private @Id @GeneratedValue Integer id;
	private String nombre;

}//end Categoria