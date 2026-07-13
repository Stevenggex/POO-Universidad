package org.spboot.clasespboot;

import org.spboot.clasespboot.Producto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/productos") // URL base
public class ProductoController {

    // 1. Inyectamos el repositorio en lugar de la lista en memoria
    private final ProductoRepository productoRepository;

    // El constructor sirve para que Spring inyecte el repositorio automáticamente
    public ProductoController(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    // 1. GET - Obtener todos los productos de la BD
    @GetMapping
    public List<Producto> obtenerTodos() {
        return productoRepository.findAll();
    }

    // 2. POST - Guardar en la base de datos
    @PostMapping
    public Producto guardarProducto(@RequestBody Producto nuevoProducto) {
        return productoRepository.save(nuevoProducto);
    }

    // 3. PUT - Actualizar un producto existente
    @PutMapping("/{id}")
    public Producto actualizarProducto(@PathVariable Long id, @RequestBody Producto datosActualizados) {
        return productoRepository.findById(id)
                .map(productoExistente ->{
                    productoExistente.setNombre(datosActualizados.getNombre());
                    productoExistente.setPrecio(datosActualizados.getPrecio());
                    return productoRepository.save(productoExistente);
                })
                .orElse(null);
    }

    // 4. DELETE - Borrar de la base de datos
    @DeleteMapping("/{id}")
    public String eliminarProducto(@PathVariable Long id) {
        if (productoRepository.existsById(id)) {
            productoRepository.deleteById(id);
            return "Producto con ID " + id + " eliminado con éxito.";
        }
        return "Producto no encontrado.";
    }
}