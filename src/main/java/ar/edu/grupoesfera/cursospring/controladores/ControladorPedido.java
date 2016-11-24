package ar.edu.grupoesfera.cursospring.controladores;

import java.util.Iterator;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.grupoesfera.cursospring.modelo.EstadoPedido;
import ar.edu.grupoesfera.cursospring.modelo.Producto;
import ar.edu.grupoesfera.cursospring.servicios.CarritoServicio;
import ar.edu.grupoesfera.cursospring.servicios.ProductoServicio;
import ar.edu.grupoesfera.cursospring.servicios.UsuarioServicio;

@Controller
public class ControladorPedido {
	private static final long serialVersionUID = 1L;

	@Inject
	private ProductoServicio servicioproducto;
	private CarritoServicio serviciocarrito;
	private UsuarioServicio serviciousuario;
	
	@RequestMapping (value = "/adminCarrito")
	public ModelAndView cargaVerCarrito(@ModelAttribute ("producto")Producto producto){
		ModelMap modelo = new ModelMap();
	    modelo.put("serviciocarrito", serviciocarrito.listadoDeCarrito());
	    modelo.put("estado", "Ver ruta de envío");
		return new ModelAndView ("adminCarrito", modelo);
	}
	
	
	
	@RequestMapping(value = "estadoResultado", method = RequestMethod.GET)
	public ModelAndView pedidoResultado(@ModelAttribute("pedido")EstadoPedido estadoPedido){
		ModelMap modelo = new ModelMap();
		//EstadoPedido pedido1 = new EstadoPedido();
		modelo.put("pedido", estadoPedido);
		return new ModelAndView("estadoResultado", modelo);
	}
}
