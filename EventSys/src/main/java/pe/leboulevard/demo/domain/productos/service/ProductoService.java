package pe.leboulevard.demo.domain.productos.service;


import pe.leboulevard.demo.domain.productos.model.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {
    List<Producto> listarProductos();
    Optional<Producto> obtenerProductoPorId(Long id);
    Producto registrarProducto(Producto producto);
    Producto actualizarProducto(Long id, Producto producto);
    boolean eliminarProducto(Long id);
}