package idat.edu.pe.cautela.jpa.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idat.edu.pe.cautela.jpa.modelo.OrdenDetalle;
import idat.edu.pe.cautela.jpa.repositorios.OrdenDetalleRepositorio;

@Service
@Transactional
public class OrdenDetalleServicios {
	
	@Autowired
	public OrdenDetalleRepositorio repositorio;

	public OrdenDetalleServicios() {
		// TODO Auto-generated constructor stub
	}
	
	public List<OrdenDetalle> buscarTodasLasOrdenesDetalles() {
		return (List<OrdenDetalle>) repositorio.findAll();
	}

	public OrdenDetalle crearOrdenDetalle(OrdenDetalle nuevaOrdenDetalle) {
		return repositorio.save(nuevaOrdenDetalle);
	}

	public OrdenDetalle Actualizar(OrdenDetalle ordenDetalleActualizar) {
		OrdenDetalle ordenDetalleActual = repositorio.findById(ordenDetalleActualizar.getIdordenDetalle()).get();
		ordenDetalleActual.setFk_idOrden(ordenDetalleActualizar.getFk_idOrden());
		ordenDetalleActual.setFk_idProductoDetalle(ordenDetalleActualizar.getFk_idProductoDetalle());
		ordenDetalleActual.setCantidad(ordenDetalleActualizar.getCantidad());
		ordenDetalleActual.setPrecio(ordenDetalleActualizar.getPrecio());
	    OrdenDetalle ordenDetalleActualizado = repositorio.save(ordenDetalleActual);
		return ordenDetalleActualizado;
	}

	public OrdenDetalle buscarPorID(Integer idordenDetalle) {
		return repositorio.findById(idordenDetalle).get();
	}

	public void borrarOrdenDetalle(Integer idordenDetalle) {
		repositorio.deleteById(idordenDetalle);
	}

}
