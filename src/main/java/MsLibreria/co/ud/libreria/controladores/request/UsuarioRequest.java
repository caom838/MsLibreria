package MsLibreria.co.ud.libreria.controladores.request;

import java.io.Serializable;

import lombok.Data;

@Data
public class UsuarioRequest implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long id;

	private String contrasena;

	private Boolean estado;
	
	private String nombreUsuario;
}
