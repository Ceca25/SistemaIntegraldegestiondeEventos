package pe.leboulevard.demo.infrastructure.persistence.organizacion.departamentos.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import pe.leboulevard.demo.infrastructure.persistence.shared.Auditoria;

@Entity
@Table(name = "departamentos")
@Getter
@Setter

public class DepartamentosEntity extends Auditoria<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_departamento")
    private Long idDepartamento;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

}
