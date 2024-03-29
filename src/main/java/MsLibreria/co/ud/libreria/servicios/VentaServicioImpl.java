package MsLibreria.co.ud.libreria.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import MsLibreria.co.ud.libreria.modelo.Item;
import MsLibreria.co.ud.libreria.modelo.Persona;
import MsLibreria.co.ud.libreria.modelo.Venta;
import MsLibreria.co.ud.libreria.repositorio.LogRepository;
import MsLibreria.co.ud.libreria.repositorio.VentaRepository;

@Service
public class VentaServicioImpl implements VentaServicio {

	@Autowired
	VentaRepository ventaRepository;
	
	@Autowired
	LogRepository logRepository;
	
	@Override
	public Double calcularTotal(List<Item> items) {
		Double resultado =0.0;
		for(Item i : items)
		{
			resultado = Double.sum(resultado,  i.getPrecioVenta().doubleValue());
		}
		return resultado;
	}

	@Override
	public Venta consultar(Long id) {
		return ventaRepository.findOne(id);
	}

	@Override
	public Boolean registrarVenta(Venta venta) {
		Venta v =ventaRepository.save(venta);
		return v!=null?true:false;
	}

	@Override
	public Boolean editarVenta(Venta venta) {

		Venta v =ventaRepository.save(venta);
		return v!=null?true:false;
	}

	
	@Override
	public List<Venta> consultarVentas() {
		return (List<Venta>)ventaRepository.findAll();
	}

	@Override
	public Optional<Venta> consultarPorPersona(Persona persona) {
		return ventaRepository.findByPersona(persona);
	}
}
