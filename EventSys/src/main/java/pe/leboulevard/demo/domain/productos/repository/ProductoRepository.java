package pe.leboulevard.demo.domain.productos.repository;

import pe.leboulevard.demo.domain.productos.model.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoRepository {
    List<Producto> findAll();
    Optional<Producto> findById(Long id);
    Producto save(Producto producto);
    void deleteById(Long id);
}