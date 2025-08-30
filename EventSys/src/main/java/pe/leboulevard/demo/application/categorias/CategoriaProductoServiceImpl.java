package pe.leboulevard.demo.application.categorias;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.leboulevard.demo.domain.categorias.model.CategoriaProducto;
import pe.leboulevard.demo.domain.categorias.service.CategoriaProductoService;
import pe.leboulevard.demo.infrastructure.categorias.jpa.CategoriaProductoRepositoryJpa;
import pe.leboulevard.demo.infrastructure.categorias.mapper.CategoriaProductoMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoriaProductoServiceImpl implements CategoriaProductoService {

    private final CategoriaProductoRepositoryJpa categoriaProductoRepositoryJpa;
    private final CategoriaProductoMapper categoriaProductoMapper;

    @Override
    public List<CategoriaProducto> listarCategorias() {
        return categoriaProductoRepositoryJpa.findAll()
                .stream()
                .map(categoriaProductoMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CategoriaProducto> obtenerCategoriaPorId(Long id) {
        return categoriaProductoRepositoryJpa.findById(id)
                .map(categoriaProductoMapper::toDomain);
    }
}
