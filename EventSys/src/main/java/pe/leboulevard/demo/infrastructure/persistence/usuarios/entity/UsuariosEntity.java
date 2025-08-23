package pe.leboulevard.demo.infrastructure.persistence.usuarios.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name="usuarios")
@Getter
@Setter

public class UsuariosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_usuario")
    private Long id_usuario;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "password_hash")
    private String password_hash;

    @Column(name = "id_rol")
    private Long id_rol;

    @Column(name = "id_empleado")
    private String id_empleado;

    @Column(name = "ultimo_acceso")
    private String ultimo_acceso;

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
