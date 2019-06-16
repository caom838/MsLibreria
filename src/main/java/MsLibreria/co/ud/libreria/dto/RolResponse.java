package MsLibreria.co.ud.libreria.dto;

import java.io.Serializable;
import java.util.List;

import MsLibreria.co.ud.libreria.modelo.Privilegio;
import lombok.Data;

@Data
public class RolResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Long id;
	
	private String descripcion;
	private boolean estado;
	
	private List<Privilegio> privilegios;
}
