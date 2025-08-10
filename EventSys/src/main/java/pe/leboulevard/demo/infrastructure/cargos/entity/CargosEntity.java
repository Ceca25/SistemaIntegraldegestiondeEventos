package pe.leboulevard.demo.infrastructure.cargos.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "cargos")
@Getter
@Setter
public class CargosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_cargo")
    private Long id_cargo;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "id_departamento")
    private Long id_departamento;
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