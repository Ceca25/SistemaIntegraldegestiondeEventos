package pe.leboulevard.demo.domain.usuarios.model;


import lombok.Data;

import java.time.LocalDate;

@Data
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
public class UsuariosModel {

    private Long id_usuario;
    private String username;
    private String email;
    private String password_hash;
    private Long id_rol;
    private Long id_empleado;
    private Boolean activo;
    //Campos dde auditoria
    private LocalDate fecha_creacion;
    private String usuario_creacion;
    private LocalDate fecha_actualizacion;
    private String usuario_actualizacion;
}
