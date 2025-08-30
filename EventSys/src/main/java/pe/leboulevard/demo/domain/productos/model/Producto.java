package pe.leboulevard.demo.domain.productos.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.leboulevard.demo.domain.categorias.model.CategoriaProducto;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class Producto {

    private Integer id;
    private String nombre;
    private String descripcion;
    private BigDecimal precioUnitario;
    private Integer stockActual;

    // Relación con categoría
    private CategoriaProducto categoria;

    // Campos de auditoría
    private String usuarioCreacion;
    private String usuarioActualizacion;
}
