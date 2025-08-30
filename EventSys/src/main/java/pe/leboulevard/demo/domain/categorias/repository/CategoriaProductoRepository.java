package pe.leboulevard.demo.domain.categorias.repository;

import pe.leboulevard.demo.domain.categorias.model.CategoriaProducto;

import java.util.List;
import java.util.Optional;

public interface CategoriaProductoRepository {
    List<CategoriaProducto> findAll();
    Optional<CategoriaProducto> findById(Long id);
}