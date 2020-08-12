package idat.edu.pe.cautela.jpa.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import idat.edu.pe.cautela.jpa.modelo.Usuario;

@Repository
public interface UsuarioRepositorio extends CrudRepository<Usuario, Integer> {

}
