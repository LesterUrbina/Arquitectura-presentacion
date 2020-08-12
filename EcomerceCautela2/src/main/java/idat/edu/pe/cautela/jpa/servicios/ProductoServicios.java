package idat.edu.pe.cautela.jpa.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idat.edu.pe.cautela.jpa.modelo.Producto;
import idat.edu.pe.cautela.jpa.repositorios.ProductoRepositorio;

@Service
@Transactional
public class ProductoServicios {

	@Autowired
	public ProductoRepositorio repositorio;
	
	public ProductoServicios() {
		// TODO Auto-generated constructor stub
	}
	
	public List<Producto> buscarTodo() {
		return (List<Producto>) repositorio.findAll();
	}

	public Producto crearProducto(Producto nuevoproducto) {
		return repositorio.save(nuevoproducto);
	}

	public Producto Actualizar(Producto productoActualizar) {
		Producto productoActual = repositorio.findById(productoActualizar.getIdProducto()).get();
		productoActual.setNombre(productoActualizar.getNombre());
		productoActual.setFecha(productoActualizar.getFecha());
		productoActual.setPrecio(productoActualizar.getPrecio());
		Producto productoActualizado = repositorio.save(productoActual);
		return productoActualizado;
	}

	public Producto buscarPorID(Integer idProducto) {
		return repositorio.findById(idProducto).get();
	}

	public void borrarProducto(Integer idProducto) {
		repositorio.deleteById(idProducto);
	}

}
