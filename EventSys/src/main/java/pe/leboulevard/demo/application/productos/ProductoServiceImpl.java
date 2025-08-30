package pe.leboulevard.demo.application.productos;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.leboulevard.demo.domain.productos.model.Producto;
import pe.leboulevard.demo.domain.productos.service.ProductoService;
import pe.leboulevard.demo.infrastructure.productos.jpa.ProductoRepositoryJpa;
import pe.leboulevard.demo.infrastructure.productos.mapper.ProductoMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepositoryJpa productoRepositoryJpa;
    private final ProductoMapper productoMapper;

    @Override
    public List<Producto> listarProductos() {
        return productoRepositoryJpa.findAll()
                .stream()
                .map(productoMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Producto> obtenerProductoPorId(Long id) {
        return productoRepositoryJpa.findById(id)
                .map(productoMapper::toDomain);
    }

    @Override
    public Producto registrarProducto(Producto producto) {
        if (producto.getCategoria() == null || producto.getCategoria().getId() == null) {
            throw new RuntimeException("El producto debe tener una categoría válida");
        }

        var entity = productoMapper.toEntity(producto);
        entity.setUsuarioCreacion("admin");
        entity.setUsuarioActualizacion("admin");

        var saved = productoRepositoryJpa.save(entity);
        return productoMapper.toDomain(saved);
    }




    @Override
    public Producto actualizarProducto(Long id, Producto producto) {
        return productoRepositoryJpa.findById(id)
                .map(existing -> {
                    existing.setNombre(producto.getNombre());
                    existing.setDescripcion(producto.getDescripcion());
                    existing.setPrecioUnitario(producto.getPrecioUnitario()); // ✅ corregido
                    existing.setStockActual(producto.getStockActual());

                    // categoría se actualiza con el mapper
                    existing.setCategoria(productoMapper.toEntity(producto).getCategoria());

                    // auditoría
                    existing.setUsuarioActualizacion("admin"); // o usuario autenticado

                    var updated = productoRepositoryJpa.save(existing);
                    return productoMapper.toDomain(updated);
                })
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con id " + id));
    }


    @Override
    public boolean eliminarProducto(Long id) {
        if (!productoRepositoryJpa.existsById(id)) {
            return false;
        }
        productoRepositoryJpa.deleteById(id);
        return true;
    }

}
