package pe.leboulevard.demo.infrastructure.permisos.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "permisos")
@Getter
@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
public class PermisosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_permiso")
    private Long id_permiso;

    @Column(name = "id_usuario")
    private Long id_usuario;

    @Column(name = "id_rol")
    private Long id_rol;

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
