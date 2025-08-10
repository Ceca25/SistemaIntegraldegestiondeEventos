package pe.leboulevard.demo.domain.roles.model;


import lombok.Data;

import java.time.LocalDate;

@Data
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
public class RolesModel {

    private Long id_rol;
    private String nombre;
    private String descripcion;
    private Boolean activo;
    //Campos dde auditoria
    private LocalDate fecha_creacion;
    private String usuario_creacion;
    private LocalDate fecha_actualizacion;
    private String usuario_actualizacion;

}
