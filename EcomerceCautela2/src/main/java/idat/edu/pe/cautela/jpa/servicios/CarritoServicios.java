package idat.edu.pe.cautela.jpa.servicios;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idat.edu.pe.cautela.jpa.modelo.Carrito;
import idat.edu.pe.cautela.jpa.repositorios.CarritoRepositorio;


@Service
@Transactional
public class CarritoServicios {

	@Autowired
	private CarritoRepositorio repositorio;
	
	public CarritoServicios() {
		// TODO Auto-generated constructor stub
	}

	
	public Carrito crearCarrito(Carrito nuevoCarrito) 
	{
		return repositorio.save(nuevoCarrito);
	}
	
	public List<Carrito> buscarTodoLosCarritos() 
	{
		return (List<Carrito>) repositorio.findAll();
	}
	public Carrito Actualizar(Carrito carritoActualizar) {
		   Carrito carritoActual = repositorio.findById(carritoActualizar.getIdCarrito()).get();
		   carritoActual.setFk_idUsuarioCarrito(carritoActualizar.getFk_idUsuarioCarrito());
		   carritoActual.setFk_idProductoCarrito(carritoActualizar.getFk_idProductoCarrito());
		   carritoActual.setCantidad(carritoActualizar.getCantidad());
		   Carrito carritoActualizado = repositorio.save(carritoActual);
		   return carritoActualizado;
	}
	
	public Carrito buscarPorID(Integer idCarrito) {
		return repositorio.findById(idCarrito).get();
	}

	public void borrarCarrito(Integer idCarrito) {
		repositorio.deleteById(idCarrito);
	}
	
}
