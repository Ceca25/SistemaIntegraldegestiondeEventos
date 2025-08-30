package pe.leboulevard.demo.domain.categorias.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaProducto {
    private Integer id;
    private String nombre;
}