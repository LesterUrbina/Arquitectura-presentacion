package idat.edu.pe.cautela.jpa;



import java.util.Date;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import idat.edu.pe.cautela.jpa.modelo.Usuario;
import idat.edu.pe.cautela.jpa.servicios.UsuarioServicios;


@SpringBootApplication
public class EcomerceCautelaApplication {

	public static void main(String[] args) {
	   ConfigurableApplicationContext ctx = SpringApplication.run(EcomerceCautelaApplication.class, args);
	   
	      // testCrearUsuario(ctx);
	  //  testBorrarUsuario(ctx);
		  // testActualizarUsuario(ctx);
		
	}

	private static void testCrearUsuario(ConfigurableApplicationContext ctx) {
		// TODO Auto-generated method stub
		
		UsuarioServicios servicio = ctx.getBean(UsuarioServicios.class);
		
		Usuario usuario = new Usuario();
		
	   usuario.setEmail("Prueba3@gmail.com");
		usuario.setPass("2514");
		usuario.setFecha(new Date());
		usuario.setNombres("Roxana ");
		usuario.setApellidos("Flores Rodriguez");
		
		servicio.crearUsuario(usuario);
	}
	
	private static void testBuscarUsuario(ConfigurableApplicationContext ctx)
	{
		
		UsuarioServicios servicio = ctx.getBean(UsuarioServicios.class);
		List<Usuario> listaUsuarios= servicio.buscarTodoLosUsuarios();
		System.out.println("Lista de Usuarios encontrada en BD");
		System.out.println(listaUsuarios);
	}
	
	private static void testBorrarUsuario(ConfigurableApplicationContext ctx)
	{
		
		UsuarioServicios servicio = ctx.getBean(UsuarioServicios.class);
		servicio.borrarUsuario(14);
	}
	

}
