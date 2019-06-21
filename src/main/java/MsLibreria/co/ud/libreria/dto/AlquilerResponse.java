package MsLibreria.co.ud.libreria.dto;

import java.util.Date;
import java.util.List;

import MsLibreria.co.ud.libreria.modelo.MedioPago;
import lombok.Data;

@Data
public class AlquilerResponse {

	private Long id;
	private String comentarios;
	private List<ItemRequest> items;
	private MedioPago medioPago;
	private PersonaResponse persona;
	private Double valor;

	private Date fechaEntrega;
	private Date fechaRealEntrega;

}
