package training.spring.restful.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import training.spring.restful.domain.Producto;

@RestController
@RequestMapping("/productos")
public class ProductoResource {
	private List<Producto> productos = new ArrayList<Producto>();
	
	@GetMapping
	public List<Producto> obtenerProductos(){
		return productos;
	}
	
	//obtener por id
	@GetMapping("/{id}")
	public Producto obtenerProductoPorId(@PathVariable long id) {
		for (Producto producto : productos) {
			if (producto.getId().equals(id)) {
				return producto;
			}
		}
		return null;
	}
	//crear nuevo producto
	@PostMapping
	public Producto crearProducto(@RequestBody Producto producto) {
		producto.setId(System.currentTimeMillis());
		productos.add(producto);
		return producto;
	}
	
	@PutMapping("/{id}")
	public Producto actualizarProducto(@PathVariable Long id, @RequestBody Producto productoActualizado) {
		for (Producto producto : productos) {
			if (producto.getId().equals(id)) {
				producto.setNombre(productoActualizado.getNombre());
				producto.setPrecio(productoActualizado.getPrecio());
				return producto;
			}
		}
		return null;
	}
}
