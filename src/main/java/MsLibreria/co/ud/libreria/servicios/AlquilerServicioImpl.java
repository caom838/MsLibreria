package MsLibreria.co.ud.libreria.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import MsLibreria.co.ud.libreria.modelo.Alquiler;
import MsLibreria.co.ud.libreria.repositorio.AlquilerRepository;

@Service
public class AlquilerServicioImpl implements AlquilerServicio {

	@Autowired
	AlquilerRepository alquilerRepository;
	
	@Override
	public Double calcularTotal() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Alquiler consultar(Long id) {
		return alquilerRepository.findOne(id);
	}

	@Override
	public Boolean registrarAlquiler(Alquiler alquiler) {
		Alquiler a =alquilerRepository.save(alquiler);
		return a!=null?true:false;
	}

	@Override
	public Boolean editarAlquiler(Alquiler alquiler) {
		Alquiler a =alquilerRepository.save(alquiler);
		return a!=null?true:false;
	}

	@Override
	public List<Alquiler> consultarAlquileres() {

		return (List<Alquiler>)alquilerRepository.findAll();
	}
	

}
