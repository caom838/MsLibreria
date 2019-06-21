package MsLibreria.co.ud.libreria.servicios;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import MsLibreria.co.ud.libreria.dto.AlquilerResponse;
import MsLibreria.co.ud.libreria.dto.ItemRequest;
import MsLibreria.co.ud.libreria.modelo.Alquiler;
import MsLibreria.co.ud.libreria.modelo.Item;
import MsLibreria.co.ud.libreria.modelo.Log;
import MsLibreria.co.ud.libreria.modelo.Usuario;
import MsLibreria.co.ud.libreria.repositorio.AlquilerRepository;
import MsLibreria.co.ud.libreria.repositorio.LogRepository;
import MsLibreria.co.ud.libreria.utils.Utileria;

@Service
public class AlquilerServicioImpl implements AlquilerServicio {

	private static final String INSERTAR_LOG = "Se crea el alquiler";
	private static final String ACTUALIZAR_LOG = "Se actualiza el alquiler";
		
	@Autowired
	AlquilerRepository alquilerRepository;
	
	@Autowired
	LogRepository logRepository;
	
	@Override
	public Double calcularTotal(List<Item> items) {
		
		Double resultado =0.0;
		for(Item i : items)
		{
			resultado = Double.sum(resultado,  i.getPrecioAlquiler().doubleValue());
		}
		return resultado;
		
	}

	@Override
	public AlquilerResponse consultar(Long id) {
		return Utileria.convertirAlquiler(alquilerRepository.findOne(id));
	}

	@Transactional
	@Override
	public Boolean registrarAlquiler(Alquiler alquiler) {
		Alquiler a =alquilerRepository.save(alquiler);
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		Usuario u = new Usuario();
		u.setId( a.getPersona().getUsuario().getId());
		Log log = new Log();
		log.setDescripcion(INSERTAR_LOG + " " + a.getId());
		log.setFecha(date);
		log.setUsuario(u);
		logRepository.save(log);
		
		return a!=null?true:false;
	}

	@Override
	public Boolean editarAlquiler(Alquiler alquiler) {
		Alquiler a =alquilerRepository.save(alquiler);
		return a!=null?true:false;
	}

	@Override
	public List<AlquilerResponse> consultarAlquileres() {
		
		List<Alquiler> al = (List<Alquiler>)alquilerRepository.findAll();
		List<AlquilerResponse> ar = new ArrayList<AlquilerResponse>();
		
		for(Alquiler a : al) {
			ar.add(Utileria.convertirAlquiler(a));
		}
		return ar;
	}
	
	
	

}
