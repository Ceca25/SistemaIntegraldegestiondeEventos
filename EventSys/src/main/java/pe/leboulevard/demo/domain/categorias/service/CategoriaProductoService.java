package pe.leboulevard.demo.domain.categorias.service;

import pe.leboulevard.demo.domain.categorias.model.CategoriaProducto;

import java.util.List;
import java.util.Optional;

public interface CategoriaProductoService {
    List<CategoriaProducto> listarCategorias();
    Optional<CategoriaProducto> obtenerCategoriaPorId(Long id);
}