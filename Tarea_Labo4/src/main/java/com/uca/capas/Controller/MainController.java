package com.uca.capas.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.Domain.Producto;

@Controller
public class MainController {
	private List<Producto> productos = new ArrayList<Producto>();
	
	@GetMapping("/producto")
	public ModelAndView comprar() {
		ModelAndView mav = new ModelAndView();
		if(productos.size() < 5) {
			productos.add(new Producto(0, "mangos", 20));
			productos.add(new Producto(1, "jicama", 10));
			productos.add(new Producto(2, "limones", 30));
			productos.add(new Producto(3, "papas", 15));
			productos.add(new Producto(4, "manzanas", 25));
		}
		mav.setViewName("productos");
		mav.addObject("producto", new Producto());
		mav.addObject("productos", productos);
		
		return mav;
	}
	
	@PostMapping("/validar")
	public ModelAndView validar(Producto producto) {
		ModelAndView mav = new ModelAndView();
		producto.setNombre(productos.get(producto.getId()).getNombre());
		
		if(productos.get(producto.getId()).getCantidad() > producto.getCantidad() ) {
			
			mav.setViewName("Compra");
		}else {
			mav.setViewName("Error");
		}
		
		return mav;
	}
}
