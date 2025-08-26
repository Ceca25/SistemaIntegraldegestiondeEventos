package pe.leboulevard.demo.infrastructure.persistence.seguridad.permisos.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "estado_civil")
@Getter
@Setter

public class PermisosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_estado_civil")
    private Long idEstadoCivil;

    @Column(name = "nombre")
    private String nombre;


}
