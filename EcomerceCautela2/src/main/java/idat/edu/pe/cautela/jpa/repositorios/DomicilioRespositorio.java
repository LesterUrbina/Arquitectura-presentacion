package idat.edu.pe.cautela.jpa.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import idat.edu.pe.cautela.jpa.modelo.Domicilio;

@Repository
public interface DomicilioRespositorio extends CrudRepository<Domicilio, Integer> {

}
