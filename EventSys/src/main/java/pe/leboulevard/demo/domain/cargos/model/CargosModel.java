package pe.leboulevard.demo.domain.cargos.model;

import lombok.*;

import java.time.LocalDate;


@Data

public class CargosModel {

    private Long id_cargo;
    private String nombre;
    private String descripcion;
    private Boolean activo;
    private Long id_departamento;
    //Campos dde auditoria
    private LocalDate fecha_creacion;
    private String usuario_creacion;
    private LocalDate fecha_actualizacion;
    private String usuario_actualizacion;
}
