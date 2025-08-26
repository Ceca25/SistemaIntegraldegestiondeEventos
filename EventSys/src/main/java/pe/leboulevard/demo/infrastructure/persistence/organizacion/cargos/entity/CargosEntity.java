package pe.leboulevard.demo.infrastructure.persistence.organizacion.cargos.entity;

import jakarta.persistence.*;
import lombok.*;
import pe.leboulevard.demo.infrastructure.persistence.organizacion.departamentos.entity.DepartamentosEntity;
import pe.leboulevard.demo.infrastructure.persistence.shared.Auditoria;

@Entity
@Table(name = "cargos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CargosEntity extends Auditoria<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_cargo")
    private Long idCargo;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    // Relación con Departamentos
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_departamento", nullable = false)
    private DepartamentosEntity departamento;
}

