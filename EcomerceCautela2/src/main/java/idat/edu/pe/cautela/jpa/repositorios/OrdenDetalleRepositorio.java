package idat.edu.pe.cautela.jpa.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import idat.edu.pe.cautela.jpa.modelo.OrdenDetalle;


@Repository
public interface OrdenDetalleRepositorio extends CrudRepository<OrdenDetalle, Integer> {

}
