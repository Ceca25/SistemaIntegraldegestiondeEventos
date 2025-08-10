package pe.leboulevard.demo.domain.empleados.model;

import lombok.Data;
import java.time.LocalDate;

@Data
public class EmpleadosModel {

    private long id_empleado;
    private String nombres;
    private String apellidos;
    private String documento_identidad;
    private String tipo_documento;
    private LocalDate fecha_nacimiento;
    private String genero;
    private String estado_civil;
    private String telefono;
    private String email_personal;
    private String email_corporativo;
    private String direccion;
    private LocalDate fecha_ingreso;
    private LocalDate fecha_salida;
    private String estado;
    private String id_cargo;
    private String id_departamento;
    //Campos de auditoria
    private LocalDate fecha_creacion;
    private String usuario_creacion;
    private LocalDate fecha_actualizacion;
    private String usuario_actualizacion;
}
