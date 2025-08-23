package pe.leboulevard.demo.infrastructure.persistence.empleados.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name="empleados")
@Getter
@Setter
public class EmpleadosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_empleado")
    private long id_empleado;

    @Column(name = "nombres")
    private String nombres;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "documento_identidad")
    private String documento_identidad;

    @Column(name = "tipo_documento")
    private String tipo_documento;

    @Column(name = "fecha_nacimiento")
    private String fecha_nacimiento;

    @Column(name = "genero")
    private String genero;

    @Column(name = "estado_civil")
    private String estado_civil;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "email_personal")
    private String email_personal;

    @Column(name = "email_corporativo")
    private String email_corporativo;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "fecha_ingreso")
    private LocalDate fecha_ingreso;

    @Column(name = "fecha_salida")
    private LocalDate fecha_salida;

    @Column(name = "estado")
    private String estado;

    @Column(name = "id_cargo")
    private long id_cargo;

    @Column(name = "id_departamento")
    private Long id_departamento;

    @Column(name = "fecha_creacion")
    private LocalDate fecha_creacion;

    @Column(name = "usuario_creacion")
    private String usuario_creacion;

    @Column(name = "fecha_actualizacion")
    private LocalDate fecha_actualizacion;

    @Column(name = "usuario_actualizacion")
    private String usuario_actualizacion;
}
