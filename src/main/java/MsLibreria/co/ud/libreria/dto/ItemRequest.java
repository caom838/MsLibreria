package MsLibreria.co.ud.libreria.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import lombok.Data;

@Data
public class ItemRequest implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	

	private Boolean banderaAlquiler;


	private String codigoReferencia;

	private String descripcion;

	private Boolean estado;

	private String nombre;


	private BigDecimal precioAlquiler;

	private BigDecimal precioVenta;

	private Integer stock;
	
	List<CategoriaDTO> categorias;
}
