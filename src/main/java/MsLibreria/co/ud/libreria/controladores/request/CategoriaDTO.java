package MsLibreria.co.ud.libreria.controladores.request;

import java.io.Serializable;

import lombok.Data;

@Data
public class CategoriaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nombre;
}
