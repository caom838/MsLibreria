package MsLibreria.co.ud.libreria.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import MsLibreria.co.ud.libreria.modelo.Alquiler;
import MsLibreria.co.ud.libreria.modelo.TarjetaCredito;
import MsLibreria.co.ud.libreria.modelo.Venta;
import lombok.Data;

@Data
public class PersonaResponse implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String apellidos;
	private String correoElectronico;
	private String direccionDomicilio;
	private Boolean estado;
	private Date fechaRegistro;
	private String identificador;
	private String nombres;
	private String telefono;
	private String tipoIdentificador;
	private UsuarioResponse usuario;
	private List<TarjetaCredito> tarjetasCredito;
	private List<Alquiler> alquilers;
	private List<Venta> ventas;
}
