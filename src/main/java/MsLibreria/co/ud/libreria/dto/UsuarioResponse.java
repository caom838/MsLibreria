package MsLibreria.co.ud.libreria.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class UsuarioResponse implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long id;
		
	private String contrasena;

	private Boolean estado;
	
	private String nombreUsuario;
	
	private RolResponse rol;
}
