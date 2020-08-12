package idat.edu.pe.cautela.jpa.servicios;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idat.edu.pe.cautela.jpa.modelo.Orden;
import idat.edu.pe.cautela.jpa.repositorios.OrdenRepositorio;

@Service
@Transactional
public class OrdenServicios {

	@Autowired
	public OrdenRepositorio repositorio;
	
	public OrdenServicios() {
		// TODO Auto-generated constructor stub
	}
	
	public List<Orden> buscarTodoLasOrdenes() {
		return (List<Orden>) repositorio.findAll();
	}
	public Orden crearOrden (Orden nuevaOrden) {
		return repositorio.save(nuevaOrden);
	}

	public Orden Actualizar(Orden ordenActualizar) {
		Orden ordenActual = repositorio.findById(ordenActualizar.getIdOrden()).get();
		ordenActual.setFk_idUsuarioOrden(ordenActualizar.getFk_idUsuarioOrden());
		ordenActual.setMetodoPagoOrden(ordenActualizar.getMetodoPagoOrden());
		ordenActual.setTotal(ordenActualizar.getTotal());
		ordenActual.setIdDomicilio(ordenActualizar.getIdDomicilio());
		Orden ordenActualizado = repositorio.save(ordenActual);
		return ordenActualizado;
	}

	public Orden buscarPorID(Integer idOrden) {
		return repositorio.findById(idOrden).get();
	}

	public void borrarOrden(Integer idOrden) {
		repositorio.deleteById(idOrden);
	}

}
