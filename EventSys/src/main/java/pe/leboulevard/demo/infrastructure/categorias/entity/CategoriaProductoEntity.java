package pe.leboulevard.demo.infrastructure.categorias.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "categorias_producto")
@Getter
@Setter
@NoArgsConstructor
public class CategoriaProductoEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Integer id;


    @Column(name = "nombre_categoria", nullable = false, length = 100)
    private String nombre;
}
