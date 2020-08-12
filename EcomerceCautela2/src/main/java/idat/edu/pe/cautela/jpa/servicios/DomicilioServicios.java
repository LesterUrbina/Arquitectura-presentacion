package idat.edu.pe.cautela.jpa.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idat.edu.pe.cautela.jpa.modelo.Domicilio;
import idat.edu.pe.cautela.jpa.repositorios.DomicilioRespositorio;

@Service
@Transactional
public class DomicilioServicios {
	@Autowired
	private DomicilioRespositorio repositorio;

	public DomicilioServicios() {
		// TODO Auto-generated constructor stub
	}
	
	public List<Domicilio> buscarTodoLosDomicilios() {
		return (List<Domicilio>) repositorio.findAll();
	}
	public Domicilio crearDomicilio (Domicilio nuevoDomicilio)
	{
		return repositorio.save(nuevoDomicilio);
	}
	
	public Domicilio Actualizar(Domicilio domicilioActualizar) {
		Domicilio domicilioActual = repositorio.findById(domicilioActualizar.getIdDomicilio()).get();
		domicilioActual.setFk_idUsuarioDomicilio(domicilioActualizar.getFk_idUsuarioDomicilio());
		domicilioActual.setDireccion(domicilioActualizar.getDireccion());
		domicilioActual.setDepartamento(domicilioActualizar.getDepartamento());
		domicilioActual.setProvincia(domicilioActualizar.getProvincia());
		domicilioActual.setDistrito(domicilioActualizar.getDistrito());
		Domicilio DomicilioActualizado = repositorio.save(domicilioActual);
		return DomicilioActualizado;
	}

	public Domicilio buscarPorID(Integer idDomicilio) {
		return repositorio.findById(idDomicilio).get();
	}

	public void borrarDomicilio(Integer idDomicilio) {
		repositorio.deleteById(idDomicilio);
	}

}
