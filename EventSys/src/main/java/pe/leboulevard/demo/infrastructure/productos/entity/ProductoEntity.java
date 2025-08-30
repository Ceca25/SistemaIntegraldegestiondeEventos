package pe.leboulevard.demo.infrastructure.productos.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.leboulevard.demo.infrastructure.categorias.entity.CategoriaProductoEntity;

import java.math.BigDecimal;

@Entity
@Table(name = "productos")
@Getter
@Setter
@NoArgsConstructor
public class ProductoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column
    private String descripcion;

    @Column(name = "precio_unitario", precision = 10, scale = 2)
    private BigDecimal precioUnitario;

    @Column(name = "stock_actual")
    private Integer stockActual;

    // Relación con Categoría
    @ManyToOne
    @JoinColumn(name = "id_categoria", nullable = false)
    private CategoriaProductoEntity categoria;

    // Campos de auditoría
    @Column(name = "usuario_creacion", nullable = false)
    private String usuarioCreacion;

    @Column(name = "usuario_actualizacion")
    private String usuarioActualizacion;
}
