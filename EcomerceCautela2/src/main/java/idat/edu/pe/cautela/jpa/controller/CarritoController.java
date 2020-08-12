package idat.edu.pe.cautela.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import idat.edu.pe.cautela.jpa.modelo.Carrito;
import idat.edu.pe.cautela.jpa.servicios.CarritoServicios;

@Controller
@RequestMapping("/carritos")
public class CarritoController {
	
	@Autowired
	 private CarritoServicios servicio;
	
	@RequestMapping("/listarTodo")
	public String listarCarrito (Model model)
	{
		List<Carrito>listaCarritos=servicio.buscarTodoLosCarritos();
	
		System.out.println("tamañarray: " + listaCarritos.size());
		model.addAttribute("listaCarritos",listaCarritos);
		return "/moduloCarrito/listarTodo.html";
	}
	
	
	
}
