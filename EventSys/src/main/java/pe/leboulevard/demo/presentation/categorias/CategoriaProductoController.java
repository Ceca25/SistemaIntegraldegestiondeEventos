package pe.leboulevard.demo.presentation.categorias;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.leboulevard.demo.domain.categorias.model.CategoriaProducto;
import pe.leboulevard.demo.domain.categorias.service.CategoriaProductoService;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
@RequiredArgsConstructor
public class CategoriaProductoController {

    private final CategoriaProductoService categoriaProductoService;

    // GET: Listar categorías
    @GetMapping
    public ResponseEntity<List<CategoriaProducto>> listarCategorias() {
        return ResponseEntity.ok(categoriaProductoService.listarCategorias());
    }

    // GET: Obtener categoría por ID
    @GetMapping("/{id}")
    public ResponseEntity<CategoriaProducto> obtenerCategoria(@PathVariable Long id) {
        return categoriaProductoService.obtenerCategoriaPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
