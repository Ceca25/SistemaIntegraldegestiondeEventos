package pe.leboulevard.demo.infrastructure.persistence.roles.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name="roles")
@Getter
@Setter

public class RolesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_rol")
    private Long id_rol;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "activo",nullable = false)
    private Boolean activo = true;

    //Campos de auditoria
    @Column(name = "fecha_creacion")
    private LocalDate fecha_creacion;

    @Column(name = "usuario_creacion")
    private String usuario_creacion;

    @Column(name = "fecha_actualizacion")
    private LocalDate fecha_actualizacion;

    @Column(name = "usuario_actualizacion")
    private String usuario_actualizacion;

}
