package MsLibreria.co.ud.libreria.controladores.request;

import lombok.Data;

@Data
public class UsuarioRequest {
	
	private long id;

	private String contrasena;

	private Boolean estado;
	
	private String nombreUsuario;
}
