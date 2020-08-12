package idat.edu.pe.cautela.jpa.servicios;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idat.edu.pe.cautela.jpa.modelo.Usuario;
import idat.edu.pe.cautela.jpa.repositorios.UsuarioRepositorio;

@Service
@Transactional
public class UsuarioServicios {

	@Autowired
	private UsuarioRepositorio repositorio;
	
	
	public UsuarioServicios() {
		// TODO Auto-generated constructor stub
	}

	public Usuario crearUsuario(Usuario nuevoUsuario) 
	{
		return repositorio.save(nuevoUsuario);
	}
	
	
	public void borrarUsuario(Integer idUsuario)
	{
		repositorio.deleteById(idUsuario);
	}
	
	public List<Usuario> buscarTodoLosUsuarios()
	{
		return (List<Usuario>)repositorio.findAll();
	
	}
	
	public Usuario buscarPorId(Integer idUsuario)
	{
		return repositorio.findById(idUsuario).get();
		
	}
	
	public Usuario Actualizar(Usuario usuarioActualizar)
	{
		
		Usuario usuarioExistente = repositorio.findById(usuarioActualizar.getIdUsuario()).get();
		usuarioExistente.setEmail(usuarioActualizar.getEmail());
		usuarioExistente.setNombres(usuarioActualizar.getNombres());
		usuarioExistente.setApellidos(usuarioActualizar.getApellidos());
		Usuario usuarioActualizado = repositorio.save(usuarioExistente);
		return usuarioActualizado;
	}
	
}
