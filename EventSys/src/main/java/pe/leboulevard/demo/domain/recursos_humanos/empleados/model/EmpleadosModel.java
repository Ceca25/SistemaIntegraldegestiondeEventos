package pe.leboulevard.demo.domain.recursos_humanos.empleados.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pe.leboulevard.demo.domain.shared.model.AuditoriaModel;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = true)
public class EmpleadosModel extends AuditoriaModel {

    private long id_empleado;
    private String nombres;
    private String apellidos;
    private String documento_identidad;
    private Long id_tipo_documento;
    private LocalDate fecha_nacimiento;
    private Long id_genero;
    private Long id_estado_civil;
    private String telefono;
    private String email_personal;
    private String email_corporativo;
    private String direccion;
    private LocalDate fecha_ingreso;
    private LocalDate fecha_salida;
    private Long id_estado;
    private Long id_cargo;
    private Long id_departamento;

}
